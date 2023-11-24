package com.todo.infoedu.todolist.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Categoria;
import com.todo.infoedu.todolist.repositorio.RepositorioCategoria;

@Service
public class ServicoCategoria {
    
    @Autowired
    RepositorioCategoria categoriaRepository;

    public List<Categoria> create(Categoria categoria){
        categoriaRepository.save(categoria);
        return list();
    }

    public List<Categoria> list(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> list(UUID categoriaId){
        return categoriaRepository.findById(categoriaId);
    }

    public List<Categoria> update(Categoria categoria){
        categoriaRepository.save(categoria);
        return list();
    }

    public List<Categoria> delete(UUID categoriaId){
        categoriaRepository.deleteById(categoriaId);
        return list();
    }
}
