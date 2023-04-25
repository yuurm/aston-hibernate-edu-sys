package org.example.repositories;

import org.example.models.Student;

import java.util.List;


public interface StudentsRepository  {


    List<Student> findAll();

    void save(Student newStudent);

    Student getById(Long id);
}
