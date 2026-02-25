package com.multidbdemo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidbdemo.demo.model.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers,Long> {
}