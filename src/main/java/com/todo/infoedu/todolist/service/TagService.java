package com.todo.infoedu.todolist.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.infoedu.todolist.entity.Tag;
import com.todo.infoedu.todolist.repository.TagRepository;

@Service
public class TagService {
    
    @Autowired
    TagRepository tagRepository;

    public List<Tag> create(Tag tag){
        tagRepository.save(tag);
        return list();
    }

    public List<Tag> list(){
        return tagRepository.findAll();
    }

    public List<Tag> list(UUID tagId){
        tagRepository.findById(tagId);
        return list();
    }

    public List<Tag> update(Tag tag){
        tagRepository.save(tag);
        return list();
    }

    public List<Tag> delete(UUID tagId){
        tagRepository.deleteById(tagId);
        return list();
    }
}
