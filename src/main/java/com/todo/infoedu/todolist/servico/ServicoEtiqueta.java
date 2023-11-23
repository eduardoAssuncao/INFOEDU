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

    public List<Etiqueta> create(Etiqueta Etiqueta){
        etiquetaRepository.save(Etiqueta);
        return list();
    }

    public List<Etiqueta> list(){
        return etiquetaRepository.findAll();
    }

    public Optional<Etiqueta> list(UUID EtiquetaId){
        return etiquetaRepository.findById(EtiquetaId);
    }

    public List<Etiqueta> update(Etiqueta Etiqueta){
        etiquetaRepository.save(Etiqueta);
        return list();
    }

    public List<Etiqueta> delete(UUID EtiquetaId){
        etiquetaRepository.deleteById(EtiquetaId);
        return list();
    }
}
