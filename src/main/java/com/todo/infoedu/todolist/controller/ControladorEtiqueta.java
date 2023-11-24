package com.todo.infoedu.todolist.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.infoedu.todolist.entity.Etiqueta;
import com.todo.infoedu.todolist.servico.ServicoEtiqueta;

@RestController
@RequestMapping("/etiquetas")
public class ControladorEtiqueta {
    
    @Autowired
    ServicoEtiqueta etiquetaService;

    @GetMapping
    List<Etiqueta> getAllEtiquetas(){
        return etiquetaService.list();
    }

    @GetMapping("{etiquetaId}")
    Optional<Etiqueta> getEtiqueta(@PathVariable("etiquetaId") UUID etiquetaId){
        return etiquetaService.list(etiquetaId);
    }

    @PostMapping
    List<Etiqueta> create(@RequestBody Etiqueta etiqueta){
        return etiquetaService.create(etiqueta);
    }

    @PutMapping("{etiquetaId}")
    List<Etiqueta> update(@PathVariable("etiquetaId") UUID etiquetaId, @RequestBody Etiqueta etiqueta){
        return etiquetaService.update(etiqueta);
    }


}
