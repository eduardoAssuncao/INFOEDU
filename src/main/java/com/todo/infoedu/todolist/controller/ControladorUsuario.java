package com.todo.infoedu.todolist.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.infoedu.todolist.entity.Usuario;
import com.todo.infoedu.todolist.servico.ServicoUsuario;

@RestController
@RequestMapping("/Usuarios")
public class ControladorUsuario {

    //Injeção de dependência
    //@Autowired
    ServicoUsuario usuarioService;

    public ControladorUsuario (ServicoUsuario usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    List<Usuario> getAllUsuarios(){
        return usuarioService.list(); 
    }

    @GetMapping("{UsuarioId}")
     Optional<Usuario> getUsuario(@PathVariable("UsuarioId") UUID UsuarioId){
        return usuarioService.list(UsuarioId);
    }

    @PostMapping
    List<Usuario> create(@RequestBody Usuario Usuario){
        return usuarioService.create(Usuario);
    }

    @PutMapping("{UsuarioId}")
    List<Usuario> update(@PathVariable("UsuarioId") UUID UsuarioId, @RequestBody Usuario Usuario){
        return usuarioService.update(Usuario);
    }

    @DeleteMapping("{UsuarioId}")
    List<Usuario> delete(@PathVariable("UsuarioId") UUID UsuarioId){
        return usuarioService.delete(UsuarioId);
    }
}