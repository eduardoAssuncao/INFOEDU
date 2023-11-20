package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String userName;
    @OneToMany(mappedBy = "user")
    private List<Todo> todos;

    public User(){}

    public User( String userName, List<Todo> todos){
        this.userName = userName;
        this.todos = todos;
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

    public List<Todo> getTodo() {
        return todos;
    }

    public void setTodo(List<Todo> todos) {
        this.todos = todos;
    }

}
