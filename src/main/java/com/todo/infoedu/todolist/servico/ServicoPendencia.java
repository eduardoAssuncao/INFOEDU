package com.todo.infoedu.todolist.servico;

import java.util.List;
import java.util.Optional;

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

    public Pendencia create(Pendencia pendencia){
        return pendenciaRepository.save(pendencia);
    }

    public List<Pendencia> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return pendenciaRepository.findAll(sort);
    }

    public Optional<Pendencia> list(Long pendenciaId){
        return pendenciaRepository.findById(pendenciaId);
    }

    public Pendencia update(Long pendenciaId, Pendencia pendenciaAtualizada){
        return pendenciaRepository.findById(pendenciaId)
                .map(pendencia -> {
                    pendencia.setNome(pendenciaAtualizada.getNome());
                    pendencia.setDescricao(pendenciaAtualizada.getDescricao());
                    pendencia.setPrioridade(pendenciaAtualizada.getPrioridade());
                    pendencia.setRealizado(pendenciaAtualizada.isRealizado());
                    //pendencia.setUsuario(pendenciaAtualizada.getUsuario());
                    return pendenciaRepository.save(pendencia);
                })
                .orElse(null);
    }

    public void delete(Long pendenciaId){
        pendenciaRepository.deleteById(pendenciaId);
    }

}
