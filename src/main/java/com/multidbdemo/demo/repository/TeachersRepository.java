package com.multidbdemo.demo.repository;

import org.springframework.stereotype.Component;

import com.multidbdemo.demo.model.Teachers;

@Component
public class TeachersRepository {
    private final TeachersRepository teachersRepository;

    public TeachersRepository(TeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    public Teachers save(Teachers teacher){
        return teachersRepository.save(teacher);
    }

}