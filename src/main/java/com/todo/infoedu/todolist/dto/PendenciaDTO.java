package com.todo.infoedu.todolist.dto;

public class PendenciaDTO {

    private String nome;
    private String descricao;
    private int prioridade;
    private Long usuarioId;

    public PendenciaDTO(){}

    public PendenciaDTO(String nome, String descricao, int prioridade, Long usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.usuarioId = usuarioId;
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
}
