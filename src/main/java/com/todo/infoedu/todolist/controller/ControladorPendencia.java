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
    List<Pendencia> getAllPendencias(){
        return pendenciaService.list();
    }

    @GetMapping("{pendenciaId}")
    Optional<Pendencia> getPendencia(@PathVariable("pendenciaId") UUID pendenciaId){
        return pendenciaService.list(pendenciaId);
    }

    //path e requisições
    @PostMapping
    List<Pendencia> create(@RequestBody Pendencia pendencia){
        return pendenciaService.create(pendencia);
    } 

    //path e requisições
    @PutMapping("{pendenciaId}")
    List<Pendencia> update(@PathVariable("pendenciaId") UUID pendenciaId, @RequestBody Pendencia pendencia){
        return pendenciaService.update(pendencia);
    }

    //path e requisições
    @DeleteMapping("{pendenciaId}")
    List<Pendencia> delete(@PathVariable("id") UUID pendenciaId){
        return pendenciaService.delete(pendenciaId);
    }
}