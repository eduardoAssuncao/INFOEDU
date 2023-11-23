package com.todo.infoedu.todolist.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Category;
import com.todo.infoedu.todolist.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> create(Category category){
        categoryRepository.save(category);
        return list();
    }

    public List<Category> list(){
        return categoryRepository.findAll();
    }

    public Optional<Category> list(UUID categoryId){
        return categoryRepository.findById(categoryId);
    }

    public List<Category> update(Category category){
        categoryRepository.save(category);
        return list();
    }

    public List<Category> delete(UUID categoryId){
        categoryRepository.deleteById(categoryId);
        return list();
    }
}
