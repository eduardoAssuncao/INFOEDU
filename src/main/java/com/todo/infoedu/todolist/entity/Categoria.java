package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID CategoriaId;
    private String nome;
    private String descricao;
    @OneToMany(mappedBy = "Categoria")
    private List<Pendencia> Pendencias;


    public UUID getCategoriaId() {
        return CategoriaId;
    }
    public void setCategoriaId(UUID CategoriaId) {
        this.CategoriaId = CategoriaId;
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
    public List<Pendencia> getPendencias() {
        return Pendencias;
    }
    public void setPendencias(List<Pendencia> Pendencias) {
        this.Pendencias = Pendencias;
    }
}
