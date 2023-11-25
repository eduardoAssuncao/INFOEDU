package com.todo.infoedu.todolist.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Usuario;
import com.todo.infoedu.todolist.repositorio.RepositorioUsuario;

@Service
public class ServicoUsuario {

    //injeção de dependências
    private RepositorioUsuario usuarioRepository;

    //injeção por meio de construtor
    public ServicoUsuario(RepositorioUsuario usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> list(Long usuarioId){
        return usuarioRepository.findById(usuarioId);
    }

    public Usuario update(Long usuarioId, Usuario usuarioAtualizado){
        return usuarioRepository.findById(usuarioId)
                .map(usuario -> {
                    usuario.setUsuarioName(usuarioAtualizado.getUsuarioName());
                    return usuarioRepository.save(usuario);
                })
                .orElse(null);
    }

    public void delete(Long usuarioId){
        usuarioRepository.deleteById(usuarioId);
    }
}
