package com.multidbdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidbdemo.demo.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

}