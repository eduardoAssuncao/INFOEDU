package com.todo.infoedu.todolist.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

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
        String categoria = pendencia.getCategoria().getNome();
        List<Etiqueta> etiquetasEntidades = pendencia.getEtiquetas();
        List<String> etiquetas = etiquetasEntidades.stream()
                                            .map(Etiqueta::getNome)
                                            .collect(Collectors.toList());

        return new PendenciaDTO(nome, descricao, prioridade, usuarioId, categoria, etiquetas);
    }

    public Pendencia toPendencia(PendenciaDTO pendenciaDTO){

        String nome = pendenciaDTO.getNome();
        String descricao = pendenciaDTO.getDescricao();
        int prioridade = pendenciaDTO.getPrioridade();
        
        Long usuarioId = pendenciaDTO.getUsuarioId();
        Usuario usuario = servicoUsuario.list(usuarioId)
                                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + usuarioId));

        String categoriaNome = pendenciaDTO.getCategoria();
        Categoria categoria = new Categoria(categoriaNome);


        List<String> etiquetasNome = pendenciaDTO.getEtiquetas();
        List<Etiqueta> etiquetas = etiquetasNome.stream()
                                            .map(etiqueta -> new Etiqueta(etiqueta))
                                            .collect(Collectors.toList());

        return new Pendencia(nome, usuario, descricao, prioridade, categoria, etiquetas);
    }

    public Usuario toUser(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getName());
    }

    public UsuarioDTO toUserDto(Usuario usuario) {
        return new UsuarioDTO(usuario.getUsuarioName());
    }
}