package com.multidbdemo.demo.repository;

import org.springframework.stereotype.Component;

import com.multidbdemo.demo.model.Students;

@Component
public class StudentsRepository  {

    private final StudentsRepository studentsRepository;

    public StudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Students save(Students student){
        return studentsRepository.save(student);
    }
}