package com.todo.infoedu.todolist.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.infoedu.todolist.entity.Usuario;

//Definir como interface
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

}