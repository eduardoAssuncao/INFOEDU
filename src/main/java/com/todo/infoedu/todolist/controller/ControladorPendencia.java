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

import com.todo.infoedu.todolist.entity.Pendencia;
import com.todo.infoedu.todolist.servico.ServicoPendencia;

@RestController
@RequestMapping("/usuarios/pendencias")
public class ControladorPendencia {

    //injeção de dependências
    //injeção por meio do Autowired
    //@Autowired
    private ServicoPendencia pendenciaService;

    public ControladorPendencia(ServicoPendencia pendenciaService){
        this.pendenciaService = pendenciaService;
    }

    //path e requisições
    @GetMapping()
    public ResponseEntity<List<Pendencia>> getAllPendencias(){
        List<Pendencia> pendencias = pendenciaService.list();
        return new ResponseEntity<>(pendencias, HttpStatus.OK);
    }

    @GetMapping("/{pendenciaId}")
    public ResponseEntity<Pendencia> getPendenciaById(@PathVariable Long pendenciaId){
        Optional<Pendencia> pendencia = pendenciaService.list(pendenciaId);
        return pendencia.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
                
    }

    //path e requisições
    @PostMapping
    public ResponseEntity<Pendencia> create(@RequestBody Pendencia pendencia){
        Pendencia criarPendencia = pendenciaService.create(pendencia);
        return new ResponseEntity<>(criarPendencia,HttpStatus.CREATED);
    } 

    //path e requisições
    @PutMapping("/{pendenciaId}")
    public ResponseEntity<Pendencia> update(@PathVariable Long pendenciaId, @RequestBody Pendencia pendenciaAtualizada){
        Pendencia pendencia = pendenciaService.update(pendenciaId, pendenciaAtualizada);
        return (pendencia != null)
                ? new ResponseEntity<>(pendencia, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //path e requisições
    @DeleteMapping("/{pendenciaId}")
    public ResponseEntity<Void> delete(@PathVariable Long pendenciaId){
        pendenciaService.delete(pendenciaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}