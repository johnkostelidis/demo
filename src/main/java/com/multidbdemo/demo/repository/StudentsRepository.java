package com.multidbdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidbdemo.demo.model.Students;

public interface StudentsRepository extends JpaRepository<Students,Long> {
}