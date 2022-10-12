package com.example.wallet.controllers;

import com.example.wallet.models.Category;
import com.example.wallet.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public Category udateCategory(@PathVariable Long id,
                                    @RequestParam String newName){

        Category category= categoryService.findCategory(id);
        category.setName(newName);

        return category;
    }


    //DELETE


}
