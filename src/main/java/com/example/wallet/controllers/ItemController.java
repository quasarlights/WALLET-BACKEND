package com.example.wallet.controllers;

import com.example.wallet.models.*;
import com.example.wallet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PeriodService periodService;
    @Autowired
    private CategoryService categoryService;

    public ItemController() {
    }
//cliente eg.
    @PostMapping("/cliente")
    public String nuevoCliente(@RequestBody User user){
        System.out.println(user.getUser()+user.getPass()+user.getToken());
        return "Cliente creado";
    }


    //create
    @PostMapping("/item/create")
    public String createItem(@RequestBody User user){
        System.out.println(user);
        return "Item CREATED";
    }

    @PostMapping("/item/create/{user_id}/{person_id}/{period_id}/{category_id}")
    public String createItem(//@PathVariable("lang") String lang,
                                                @PathVariable(value = "user_id") Long userId,
                                                @PathVariable(value = "person_id") Long personId,
                                                @PathVariable(value = "period_id") Long periodId,
                                                @PathVariable(value = "category_id") Long categoryId,
                                                @RequestBody Item itemRequest) {
        System.out.println(itemRequest);
        User u = userService.findUser(userId);
        itemRequest.setUser(u);
        Person p = personService.findPerson(personId);
        itemRequest.setPerson(p);
        Period pd = periodService.findPeriod(periodId);
        itemRequest.setPeriod(pd);
        Category c = categoryService.findCategory(categoryId);
        itemRequest.setCategory(c);

        Item newItem = itemService.save(itemRequest);
        return "new ResponseEntity<>(newItem, HttpStatus.CREATED";

    }

    /*
    EL QUE SI VA::::
    @PostMapping("/person/{person_id}")
    public ResponseEntity<Education> createEducation(@PathVariable(value = "person_id") Long personId,
                                                     @RequestBody Education educationRequest) {
        Person p = personService.findById(personId);
        educationRequest.setPerson(p);
        Education newEducation = educationService.save(educationRequest);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }


EL QUE ESTABA::::::
@PostMapping("/item/create")
    public String createItem(@RequestBody Item item){
        iitemService.saveItem(item);
        return "Item CREATED";

    "/item/create/{category_id}/{period_id}/{person_id}/{user_id}"
    @PostMapping("/item/create")
    public String createItem(//@PathVariable(value = "category_id") Long categoryId,
                            //@PathVariable(value = "period_id") Long periodId,
                           //@PathVariable(value = "person_id") Long personId,
                            //@PathVariable(value = "user_id") Long userId,
                                
                            @RequestBody Item itemRequest){
        

        CategoryService c= new CategoryService();
        Category c =categoryService.findCategory(categoryId);
        if(c ==null){
            return "Create Category";
        }

        iitemService.saveItem(itemRequest);
        return "Item CREATED";
    }*/
    
    /*
    @PostMapping("/person/{person_id}")
    public ResponseEntity<Education> createEducation(@PathVariable(value = "person_id") Long personId, @RequestBody Education educationRequest) {
        Person p = personService.findById(personId);
        educationRequest.setPerson(p);
        Education newEducation = educationService.save(educationRequest);
        return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
*/
    //read
    @GetMapping("/item/read")
    public ArrayList<Item> getItem(){
        return itemService.getItem();
    }

    //update
    @PutMapping("/item/update/{id}")
    public Item updateItem(@PathVariable Long id,
                           @RequestParam("name") String newName,
                           @RequestParam("description") String newDescription,
                           @RequestParam("observation") String newObservation,
                           @RequestParam("user") User newUser,
                           @RequestParam("person") Person newPerson,
                           @RequestParam("period") Period newPeriod,
                           @RequestParam("category") Category newCategory)
    {
        Item item = itemService.findItem(id);

        item.setName(newName);
        item.setDescription(newDescription);
        item.setObservation(newObservation);
        item.setUser(newUser);
        item.setPerson(newPerson);
        item.setPeriod(newPeriod);
        item.setCategory(newCategory);

        return item;
    }

    //delete
    @DeleteMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);

        return "Item DELETE";
    }

}
