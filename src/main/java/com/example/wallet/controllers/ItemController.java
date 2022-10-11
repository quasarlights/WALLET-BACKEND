package com.example.wallet.controllers;

import com.example.wallet.interfaces.IitemService;
import com.example.wallet.models.*;
import com.example.wallet.services.CategoryService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private IitemService iitemService;

    //create
    @PostMapping("/item/create")
    public String createItem(@RequestBody Item item){
        iitemService.saveItem(item);
        return "Item CREATED";
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
        

        CategoryService categoryService= new CategoryService();
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
        return iitemService.getItem();
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
        Item item = iitemService.findItem(id);

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
        iitemService.deleteItem(id);

        return "Item DELETE";
    }

}
