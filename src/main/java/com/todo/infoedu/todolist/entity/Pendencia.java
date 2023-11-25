package com.todo.infoedu.todolist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pendencia {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long pendenciaId;
    private String nome;
    private String descricao;
    private boolean realizado = false;
    private int prioridade;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    @JsonIgnoreProperties("pendencias")
    private Usuario usuario;
    
    public Pendencia(){}

    
    public Pendencia(String nome, Usuario usuario, String descricao, int prioridade) {
        this.usuario = usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public Long getpendenciaId() {
        return pendenciaId;
    }

    public void setpendenciaId(Long pendenciaId) {
        this.pendenciaId = pendenciaId;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}