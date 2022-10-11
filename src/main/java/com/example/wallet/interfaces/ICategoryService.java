package com.example.wallet.interfaces;

import com.example.wallet.models.Category;
import java.util.ArrayList;

public interface ICategoryService {

    public ArrayList<Category> getCategory();
    public void saveCategory(Category category);
    public void deleteCategory(Long id);
    public Category findCategory(Long id);
}
