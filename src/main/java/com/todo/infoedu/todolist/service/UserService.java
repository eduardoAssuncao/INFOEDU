package com.todo.infoedu.todolist.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.User;
import com.todo.infoedu.todolist.repository.UserRepository;

@Service
public class UserService {

    //injeção de dependências
    private UserRepository userRepository;

    //injeção por meio de construtor
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public List<User> list(){
        return userRepository.findAll();
    }

    public Optional<User> list(UUID userId){
        return userRepository.findById(userId);
    }

    public List<User> update(User user){
        userRepository.save(user);
        return list();
    }

    public List<User> delete(UUID userId){
        userRepository.deleteById(userId);;
        return list();
    }
}
