package com.todo.infoedu.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.infoedu.todolist.entity.Category;
import com.todo.infoedu.todolist.service.CategoryService;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    List<Category> getAllCategorys(){
        return categoryService.list();
    }
}
