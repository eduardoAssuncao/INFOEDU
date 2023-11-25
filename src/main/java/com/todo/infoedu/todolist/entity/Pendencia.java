package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pendencia {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long pendenciaId;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Categoria categoria;
    @ManyToMany
    private List<Etiqueta> etiquetas;
    
    public Pendencia(){}

    
    public Pendencia(Long pendenciaId, String nome, String descricao, boolean realizado, int prioridade) {
        this.pendenciaId = pendenciaId;
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}