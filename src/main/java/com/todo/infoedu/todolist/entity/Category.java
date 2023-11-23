package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID categoryId;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "category")
    private List<Todo> todos;

    
    public UUID getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<Todo> getTodos() {
        return todos;
    }
    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    
}
