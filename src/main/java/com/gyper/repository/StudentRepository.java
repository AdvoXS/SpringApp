package com.gyper.repository;


import com.gyper.entity.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findByName(String name);
}