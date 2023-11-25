package com.todo.infoedu.todolist.entity;

import java.util.List;

public class PendenciaDTO {

    private String nome;
    private String descricao;
    private int prioridade;
    private Long usuarioId;
    private String categoria;
    private List<String> etiquetas;

    public PendenciaDTO(){}

    public PendenciaDTO(String nome, String descricao, int prioridade, Long usuarioId, String categoria, List<String> etiquetas) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.usuarioId = usuarioId;
        this.categoria = categoria;
        this.etiquetas = etiquetas;
    }  

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<String> getEtiquetas() {
        return this.etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }
    
}
