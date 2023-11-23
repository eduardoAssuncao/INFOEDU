package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pendencia {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID PendenciaId;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;
    @ManyToOne
    @JoinColumn(name="UsuarioId", nullable=false)
    private Usuario Usuario;
    @ManyToOne
    private Categoria Categoria;
    @ManyToMany
    private List<Etiqueta> Etiquetas;
    
    public Pendencia(){}

    public Pendencia(String nome, String descricao, boolean realizado, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public UUID getPendenciaId() {
        return PendenciaId;
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

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setPendenciaId(UUID PendenciaId) {
        this.PendenciaId = PendenciaId;
    }
}