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

import com.todo.infoedu.todolist.entity.Etiqueta;
import com.todo.infoedu.todolist.servico.ServicoEtiqueta;

@RestController
@RequestMapping("/etiquetas")
public class ControladorEtiqueta {
    
    @Autowired
    ServicoEtiqueta etiquetaService;

    @GetMapping
    public ResponseEntity<List<Etiqueta>> getAllEtiquetas(){
        List<Etiqueta> etiquetas = etiquetaService.list();
        return new ResponseEntity<>(etiquetas, HttpStatus.OK);
    }

    @GetMapping("/{etiquetaId}")
    public ResponseEntity<Etiqueta> getEtiquetaById(@PathVariable Long etiquetaId){
        Optional<Etiqueta> etiqueta = etiquetaService.list(etiquetaId);
        return etiqueta.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Etiqueta> create(@RequestBody Etiqueta etiqueta){
        Etiqueta criarEtiqueta = etiquetaService.create(etiqueta);
        return new ResponseEntity<>(criarEtiqueta, HttpStatus.CREATED);
    }

    @PutMapping("/{etiquetaId}")
    public ResponseEntity<Etiqueta> update(@PathVariable Long etiquetaId, @RequestBody Etiqueta etiquetaAtualizada){
        Etiqueta etiqueta = etiquetaService.update(etiquetaId, etiquetaAtualizada);
        return (etiqueta != null)
                ? new ResponseEntity<>(etiqueta, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{etiquetaId}")
    public ResponseEntity<Void> delete(@PathVariable Long etiquetaId){
        etiquetaService.delete(etiquetaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
