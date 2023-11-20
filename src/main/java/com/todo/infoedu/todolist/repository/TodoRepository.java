package com.todo.infoedu.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Todo;

//Definição de interface
public interface TodoRepository extends JpaRepository<Todo, UUID> {

}