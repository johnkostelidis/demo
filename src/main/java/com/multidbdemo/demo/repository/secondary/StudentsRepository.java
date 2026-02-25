package com.multidbdemo.demo.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidbdemo.demo.model.secondary.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

}