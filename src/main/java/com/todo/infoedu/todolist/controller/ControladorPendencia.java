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

import com.todo.infoedu.todolist.entity.Pendencia;
import com.todo.infoedu.todolist.servico.ServicoPendencia;

@RestController
@RequestMapping("/usuarios/Pendencias")
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
    List<Pendencia> getAllPendencias(){
        return pendenciaService.list();
    }

    @GetMapping("{UUID}")
    Optional<Pendencia> getPendencia(@PathVariable("UUID") UUID PendenciaId){
        return pendenciaService.list(PendenciaId);
    }

    //path e requisições
    @PostMapping
    List<Pendencia> create(@RequestBody Pendencia Pendencia){
        return pendenciaService.create(Pendencia);
    } 

    //path e requisições
    @PutMapping("{PendenciaId}")
    List<Pendencia> update(@PathVariable("PendenciaId") UUID PendenciaId, @RequestBody Pendencia Pendencia){
        return pendenciaService.update(Pendencia);
    }

    //path e requisições
    @DeleteMapping("{PendenciaId}")
    List<Pendencia> delete(@PathVariable("id") UUID PendenciaId){
        return pendenciaService.delete(PendenciaId);
    }
}