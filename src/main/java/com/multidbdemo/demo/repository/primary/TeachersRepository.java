package com.multidbdemo.demo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multidbdemo.demo.model.primary.Teachers;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {

}