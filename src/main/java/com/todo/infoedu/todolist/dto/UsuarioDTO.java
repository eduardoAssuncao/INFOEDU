package com.todo.infoedu.todolist.dto;

public class UsuarioDTO {

    private String usuarioName;

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
}
