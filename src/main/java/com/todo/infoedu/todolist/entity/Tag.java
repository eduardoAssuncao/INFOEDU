package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID tagId;
    private String nome;
    private String cor;
    @ManyToMany(mappedBy = "tags")
    private List<Todo> todos;


    public UUID getTagId() {
        return tagId;
    }
    public void setTagId(UUID tagId) {
        this.tagId = tagId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public List<Todo> getTodos() {
        return todos;
    }
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    } 
}
