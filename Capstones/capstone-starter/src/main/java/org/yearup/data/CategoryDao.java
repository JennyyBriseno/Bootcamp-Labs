package org.yearup.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.yearup.data.mysql.MySqlCategoryDao;
import org.yearup.models.Category;

import java.util.List;

public interface CategoryDao
{
    List<Category> getAllCategories();
    Category getById(int categoryId);
    Category create(Category category);
    Category update(int categoryId, Category category);
    void delete(int categoryId);
}
