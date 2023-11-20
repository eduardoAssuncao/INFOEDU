package com.todo.infoedu.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.User;

//Definir como interface
public interface UserRepository extends JpaRepository<User, UUID>{

}