package com.todo.infoedu.todolist.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long usuarioId;
    
    private String usuarioName;
    @OneToMany(mappedBy = "usuario")
    private List<Pendencia> pendencias;

    public Usuario(){}

    public Usuario(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public List<Pendencia> getPendencias() {
        return pendencias;
    }

    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }
}
