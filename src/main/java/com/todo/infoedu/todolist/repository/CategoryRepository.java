package com.todo.infoedu.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    
}
