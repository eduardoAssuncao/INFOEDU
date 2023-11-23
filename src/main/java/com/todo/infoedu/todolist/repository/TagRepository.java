package com.todo.infoedu.todolist.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    
}
