package com.todo.infoedu.todolist.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Pendencia;
import com.todo.infoedu.todolist.repositorio.RepositorioPendencia;

@Service
public class ServicoPendencia {

    //injeção de dependências
    private RepositorioPendencia pendenciaRepository;

    //injeção por meio de construtor
    public ServicoPendencia(RepositorioPendencia pendenciaRepository){
        this.pendenciaRepository = pendenciaRepository;
    }

    public List<Pendencia> create(Pendencia pendencia){
        pendenciaRepository.save(pendencia);
        return list();
    }

    public List<Pendencia> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return pendenciaRepository.findAll(sort);
    }

    public Optional<Pendencia> list(UUID pendenciaId){
        return pendenciaRepository.findById(pendenciaId);
    }

    public List<Pendencia> update(Pendencia pendencia){
        pendenciaRepository.save(pendencia);
        return list();
    }

    public List<Pendencia> delete(UUID pendenciaId){
        pendenciaRepository.deleteById(pendenciaId);;
        return list();
    }

}
