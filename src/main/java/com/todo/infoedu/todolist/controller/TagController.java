package com.todo.infoedu.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.infoedu.todolist.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
    
    @Autowired
    TagService tagService;

    
}
