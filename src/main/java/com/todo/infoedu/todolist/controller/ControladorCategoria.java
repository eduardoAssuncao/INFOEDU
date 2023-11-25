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

import com.todo.infoedu.todolist.entity.Categoria;
import com.todo.infoedu.todolist.servico.ServicoCategoria;

@RestController
@RequestMapping("/categorias") //colocar em minusculo
public class ControladorCategoria {
    
    @Autowired
    ServicoCategoria categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categorias = categoriaService.list();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long categoriaId){
        Optional<Categoria> categoria = categoriaService.list(categoriaId);
        return categoria.map(valor -> new ResponseEntity<>(valor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        Categoria criarCategoria = categoriaService.create(categoria);
        return new ResponseEntity<>(criarCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categoria> update(@PathVariable Long categoriaId, @RequestBody Categoria categoriaAtualizada){
        Categoria categoria = categoriaService.update(categoriaId, categoriaAtualizada);
        return (categoria != null)
                ? new ResponseEntity<>(categoria, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Categoria> delete(@PathVariable Long categoriaId){
        categoriaService.delete(categoriaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //COLOAR UM DELETE ALL?
}
