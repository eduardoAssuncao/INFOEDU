package com.todo.infoedu.todolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Pendencia;

//Definição de interface
public interface RepositorioPendencia extends JpaRepository<Pendencia, Long> {

}