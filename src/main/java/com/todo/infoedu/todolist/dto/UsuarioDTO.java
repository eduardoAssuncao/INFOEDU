package com.todo.infoedu.todolist.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.infoedu.todolist.entity.Pendencia;

public class UsuarioDTO {

    private String usuarioName;
    @JsonIgnoreProperties("usuario")
    private List<Pendencia> pendencias;

    public UsuarioDTO(){}

    public UsuarioDTO(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public String getName() {
        return this.usuarioName;
    }

    public void setName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public List<Pendencia> getPendencias() {
        return this.pendencias;
    }

    public void setPendencias(List<Pendencia> pendencias) {
        this.pendencias = pendencias;
    }
}
