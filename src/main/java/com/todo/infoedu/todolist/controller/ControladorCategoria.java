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
@RequestMapping("/categorias") //colocar em minusculo
public class ControladorCategoria {
    
    @Autowired
    ServicoCategoria categoriaService;

    @GetMapping
    List<Categoria> getAllCategorias(){
        return categoriaService.list();
    }

    @GetMapping("{categoriaId}")
    Optional<Categoria> getCategoria(@PathVariable("categoriaId") UUID categoriaId){
        return categoriaService.list(categoriaId);
    }

    @PostMapping
    List<Categoria> create(@RequestBody Categoria categoria){
        return categoriaService.create(categoria);
    }

    @PutMapping("{categoriaId}")
    List<Categoria> update(@PathVariable("categoriaId") UUID categoriaId, @RequestBody Categoria categoria){
        return categoriaService.update(categoria);
    }

    @DeleteMapping("{categoriaId}")
    List<Categoria> delete(@PathVariable("categoriaId") UUID categoriaId){
        return categoriaService.delete(categoriaId);
    }

    //COLOAR UM DELETE ALL?
}
