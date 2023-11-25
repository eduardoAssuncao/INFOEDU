package com.todo.infoedu.todolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Categoria;

public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
    
}
