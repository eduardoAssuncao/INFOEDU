package com.todo.infoedu.todolist.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/usuarios")
public class ControladorUsuario {

    //Injeção de dependência
    //@Autowired
    ServicoUsuario usuarioService;

    public ControladorUsuario (ServicoUsuario usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioService.list();
        return new ResponseEntity<>(usuarios, HttpStatus.OK); 
    }

    @GetMapping("/{usuarioId}")
     public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId){
        Optional<Usuario> usuario = usuarioService.list(usuarioId);
        return usuario.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario criarUsuario = usuarioService.create(usuario);
        return new ResponseEntity<>(criarUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> update(@PathVariable Long usuarioId, @RequestBody Usuario usuarioAtualizado){
        Usuario usuario = usuarioService.update(usuarioId, usuarioAtualizado);
        return (usuario != null)
                ? new ResponseEntity<>(usuario, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> delete(@PathVariable Long usuarioId){
        usuarioService.delete(usuarioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}