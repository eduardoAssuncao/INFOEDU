package com.todo.infoedu.todolist.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.infoedu.todolist.entity.User;
import com.todo.infoedu.todolist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    //Injeção de dependência
    //@Autowired
    UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUsers(){
        return userService.list(); 
    }

    @GetMapping("{userId}")
     Optional<User> getUser(@PathVariable("userId") UUID userId){
        return userService.list(userId);
    }

    @PostMapping
    User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("{userId}")
    List<User> update(@PathVariable("userId") UUID userId, @RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("{userId}")
    List<User> delete(@PathVariable("userId") UUID userId){
        return userService.delete(userId);
    }
}