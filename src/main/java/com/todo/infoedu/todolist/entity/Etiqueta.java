package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID etiquetaId;
    private String nome;
    private String cor;
    @ManyToMany(mappedBy = "etiquetas")
    private List<Pendencia> pendencias;


    public UUID getEtiquetaId() {
        return etiquetaId;
    }
    public void setEtiquetaId(UUID etiquetaId) {
        this.etiquetaId = etiquetaId;
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
    public List<Pendencia> getPendencias() {
        return pendencias;
    }
    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    } 
}
