package com.example.wallet.controllers;

import com.example.wallet.models.Category;
import com.example.wallet.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //CREATE
    @PostMapping("/category/create")
    public String createCategory(@RequestBody Category category){
        categoryService.saveCategory(category);

        return "Category Created";
    }

    //READ
    @GetMapping("/category/read")
    public ArrayList<Category> readCategory(){
        return categoryService.getAllItem();
    }

    //UPDATE
    @PutMapping("/category/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,
                                    @RequestBody Category newCategory){

        Category category= categoryService.findCategory(id);
        newCategory.setId(category.getId());

        return new ResponseEntity<>(categoryService.save(newCategory),HttpStatus.OK);
    }
/*
     @PutMapping("/{id}")
    public ResponseEntity<Person> updateEducation(@PathVariable("id") long id, @RequestBody Person personRequest) {

        Person person = personService.findById(id);
        personRequest.setId(person.getId());
        // .orElseThrow(() -> new ResourceNotFoundException("EducationId " + id + "not found"));

        // .orElseThrow(() -> new ResourceNotFoundException("EducationId " + id + "not found"));
        return new ResponseEntity<>(personService.save(personRequest), HttpStatus.OK);

    }
*/

    //DELETE
@DeleteMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
    categoryService.deleteCategory(id);
    return "Category Deleted";
}

}
