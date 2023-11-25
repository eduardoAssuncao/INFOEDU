package com.todo.infoedu.todolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Etiqueta;

public interface RepositorioEtiqueta extends JpaRepository<Etiqueta, Long> {
    
}
