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

    public Categoria create(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> list(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> list(Long categoriaId){
        return categoriaRepository.findById(categoriaId);
    }

    public Categoria update(Long categoriaId, Categoria categoriaAtualizada){
        return categoriaRepository.findById(categoriaId)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    categoria.setDescricao(categoriaAtualizada.getDescricao());
                    return categoriaRepository.save(categoria);
                })
                .orElse(null);
    }

    public void delete(Long categoriaId){
        categoriaRepository.deleteById(categoriaId);
    }
}
