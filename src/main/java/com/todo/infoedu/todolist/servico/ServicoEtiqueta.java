package com.todo.infoedu.todolist.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Etiqueta;
import com.todo.infoedu.todolist.repositorio.RepositorioEtiqueta;

@Service
public class ServicoEtiqueta {
    
    @Autowired
    RepositorioEtiqueta etiquetaRepository;

    public Etiqueta create(Etiqueta etiqueta){
        return etiquetaRepository.save(etiqueta);
    }

    public List<Etiqueta> list(){
        return etiquetaRepository.findAll();
    }

    public Optional<Etiqueta> list(UUID etiquetaId){
        return etiquetaRepository.findById(etiquetaId);
    }

    public Etiqueta update(UUID etiquetaId, Etiqueta etiquetaAtualizada){
        return etiquetaRepository.findById(etiquetaId)
                .map(etiqueta -> {
                    etiqueta.setNome(etiquetaAtualizada.getNome());
                    etiqueta.setCor(etiquetaAtualizada.getCor());
                    return etiquetaRepository.save(etiqueta);
                })
                .orElse(null);
    }

    public void delete(UUID etiquetaId){
        etiquetaRepository.deleteById(etiquetaId);
    }
}
