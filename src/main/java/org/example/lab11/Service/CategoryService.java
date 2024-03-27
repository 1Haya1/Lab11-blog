package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiException;


import org.example.lab11.Model.Category;
import org.example.lab11.Repository.CategoryRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }


    public void addCategory(Category category){

        categoryRepository.save(category);
    }


    public void updateCategory(Integer id, Category category) {
        Category c = categoryRepository.findCategoryById(id);

        if (c == null) {
            throw new ApiException("wrong id");
        }

        c.setName(category.getName());
        categoryRepository.save(c);

    }


    public void deleteCategory(Integer id) {
        Category c = categoryRepository.findCategoryById(id);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        categoryRepository.delete(c);
    }


    public Category getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }





}



