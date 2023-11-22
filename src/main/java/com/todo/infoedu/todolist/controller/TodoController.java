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

import com.todo.infoedu.todolist.entity.Todo;
import com.todo.infoedu.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    //injeção de dependências
    //injeção por meio do Autowired
    //@Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //path e requisições
    @GetMapping()
    List<Todo> getAllTodos(){
        return todoService.list();
    }

    @GetMapping("{UUID}")
    Optional<Todo> getTodo(@PathVariable("UUID") UUID todoId){
        return todoService.list(todoId);
    }

    //path e requisições
    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    } 

    //path e requisições
    @PutMapping("{todoId}")
    List<Todo> update(@PathVariable("todoId") UUID todoId, @RequestBody Todo todo){
        return todoService.update(todo);
    }

    //path e requisições
    @DeleteMapping("{todoId}")
    List<Todo> delete(@PathVariable("id") UUID todoId){
        return todoService.delete(todoId);
    }
}