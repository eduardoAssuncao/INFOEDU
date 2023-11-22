package com.todo.infoedu.todolist.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String userName;
    @ManyToOne
    private Todo todos;
    //DEPOIS CORRIGIR E TENTAR FAZER COM QUE UM USUARIO POSSA TER VARIAS TODOS.

    public User(){

    }

    public User( String userName){
        this.userName = userName;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Todo getTodos() {
        return todos;
    }

    public void setTodos(Todo todos) {
        this.todos = todos;
    }

    

}
