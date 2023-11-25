package com.todo.infoedu.todolist.entity;

import org.springframework.stereotype.Component;

import com.todo.infoedu.todolist.dto.PendenciaDTO;
import com.todo.infoedu.todolist.dto.UsuarioDTO;
import com.todo.infoedu.todolist.servico.ServicoUsuario;

@Component
public class Mapper {
    
    //@Autowired
    private final ServicoUsuario servicoUsuario;

    public Mapper(ServicoUsuario servicoUsuario){
        this.servicoUsuario = servicoUsuario;
    }

    public PendenciaDTO toDTO(Pendencia pendencia){
        String nome = pendencia.getNome();
        String descricao = pendencia.getDescricao();
        int prioridade = pendencia.getPrioridade();
        Long usuarioId = pendencia.getUsuario().getUsuarioId();

        return new PendenciaDTO(nome, descricao, prioridade, usuarioId);
    }

    public Pendencia toPendencia(PendenciaDTO pendenciaDTO){

        String nome = pendenciaDTO.getNome();
        String descricao = pendenciaDTO.getDescricao();
        int prioridade = pendenciaDTO.getPrioridade();
        
        Long usuarioId = pendenciaDTO.getUsuarioId();
        Usuario usuario = servicoUsuario.list(usuarioId)
                                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + usuarioId));

        return new Pendencia(nome, usuario, descricao, prioridade);
    }

    public Usuario toUser(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getName());
    }

    public UsuarioDTO toUserDto(Usuario usuario) {
        return new UsuarioDTO(usuario.getUsuarioName());
    }
}