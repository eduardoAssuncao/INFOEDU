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

    public List<Usuario> create(Usuario Usuario){
        usuarioRepository.save(Usuario);
        return list();
    }

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> list(UUID UsuarioId){
        return usuarioRepository.findById(UsuarioId);
    }

    public List<Usuario> update(Usuario Usuario){
        usuarioRepository.save(Usuario);
        return list();
    }

    public List<Usuario> delete(UUID UsuarioId){
        usuarioRepository.deleteById(UsuarioId);;
        return list();
    }
}
