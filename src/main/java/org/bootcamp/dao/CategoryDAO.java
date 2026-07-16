package org.bootcamp.dao;

import org.bootcamp.models.Category;
import org.bootcamp.models.User;

import java.util.List;

public interface CategoryDAO {
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
    Category getCategory(int id);
    List<Category> showAllCategory();
}
