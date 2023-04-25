package org.example.service;

import org.example.dto.CourseDto;
import org.example.dto.StudentDto;

import java.util.List;

public interface StudentsService {


    List<StudentDto> getStudents();

    StudentDto addStudent(StudentDto student);

    StudentDto updateStudent(Long id, StudentDto student);

    void deleteStudent(Long id);

    List<CourseDto> addCourseToStudent(Long studentId, CourseDto course);
}
