package com.multidbdemo.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multidbdemo.demo.model.primary.Teachers;
import com.multidbdemo.demo.model.secondary.Students;
import com.multidbdemo.demo.repository.primary.TeachersRepository;
import com.multidbdemo.demo.repository.secondary.StudentsRepository;

@RestController
@RequestMapping("/api")
public class PeopleController {

    private final TeachersRepository teachersRepository;
    private final StudentsRepository studentsRepository;

    public PeopleController(TeachersRepository teachersRepository, StudentsRepository studentsRepository) {
        this.teachersRepository = teachersRepository;
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/people")
    public List<Object> getPeople() {
        List<Object> everyone = new ArrayList<>();
        
        List<Teachers> teachers = teachersRepository.findAll();
        everyone.addAll(teachers);
        
        List<Students> students = studentsRepository.findAll();
        everyone.addAll(students);

        return everyone;
    }
}