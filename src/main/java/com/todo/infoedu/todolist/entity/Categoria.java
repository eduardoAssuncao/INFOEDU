package com.todo.infoedu.todolist.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaId;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "categoria")
    private List<Pendencia> pendencias;

    public Categoria() {}

    public Categoria(Long categoriaId, String nome, String descricao) {
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
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
    /*public List<Pendencia> getPendencias() {
        return pendencias;
    }
    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }*/
}
