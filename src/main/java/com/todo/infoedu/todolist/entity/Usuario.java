package com.todo.infoedu.todolist.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID UsuarioId;
    private String UsuarioName;
    @OneToMany(mappedBy = "Usuario")
    private Set<Pendencia> Pendencias;
    //DEPOIS CORRIGIR E TENTAR FAZER COM QUE UM USUARIO POSSA TER VARIAS PendenciaS.

    public Usuario(){}

    public Usuario(String UsuarioName) {
        this.UsuarioName = UsuarioName;
    }

    public UUID getUsuarioId() {
        return UsuarioId;
    }

    public String getUsuarioName() {
        return UsuarioName;
    }

    public void setUsuarioName(String UsuarioName) {
        this.UsuarioName = UsuarioName;
    }

    public void setUsuarioId(UUID UsuarioId) {
        this.UsuarioId = UsuarioId;
    }

}
