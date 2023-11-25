package com.todo.infoedu.todolist.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, UUID> {
    
}