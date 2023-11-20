package com.todo.infoedu.todolist.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Todo;
import com.todo.infoedu.todolist.repository.TodoRepository;

@Service
public class TodoService {

    //injeção de dependências
    private TodoRepository todoRepository;

    //injeção por meio de construtor
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    public Optional<Todo> list(UUID todoId){
        return todoRepository.findById(todoId);
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(UUID todoId){
        todoRepository.deleteById(todoId);;
        return list();
    }

}
