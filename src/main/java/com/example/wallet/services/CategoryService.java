package com.example.wallet.services;

import com.example.wallet.interfaces.ICategoryService;
import com.example.wallet.models.Category;
import com.example.wallet.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public ArrayList<Category> getAllItem(){
        return (ArrayList<Category>) categoryRepository.findAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    @Override
    public ArrayList<Category> getCategory() {
        ArrayList<Category> categoryArrayList= (ArrayList<Category>) categoryRepository.findAll();
        return categoryArrayList;
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category findCategory(Long id) {
        Category category= categoryRepository.findById(id).orElse(null);
        return category;
    }
}
