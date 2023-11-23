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

import com.todo.infoedu.todolist.entity.Categoria;
import com.todo.infoedu.todolist.servico.ServicoCategoria;

@RestController
@RequestMapping("/Categorias")
public class ControladorCategoria {
    
    @Autowired
    ServicoCategoria categoriaService;

    @GetMapping
    List<Categoria> getAllCategorias(){
        return categoriaService.list();
    }

    @GetMapping("{CategoriaId}")
    Optional<Categoria> getCategoria(@PathVariable("CategoriaId") UUID CategoriaId){
        return categoriaService.list(CategoriaId);
    }

    @PostMapping
    List<Categoria> create(@RequestBody Categoria Categoria){
        return categoriaService.create(Categoria);
    }

    @PutMapping("{CategoriaId}")
    List<Categoria> update(@PathVariable("CategoriaId") UUID CategoriaId, @RequestBody Categoria Categoria){
        return categoriaService.update(Categoria);
    }

    @DeleteMapping("{CategoriaId}")
    List<Categoria> delete(@PathVariable("CategoriaId") UUID CategoriaId){
        return categoriaService.delete(CategoriaId);
    }

    //COLOAR UM DELETE ALL?
}
