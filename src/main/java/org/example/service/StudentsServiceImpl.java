package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CourseDto;
import org.example.dto.StudentDto;
import org.example.models.Course;
import org.example.models.Student;
import org.example.repositories.CoursesRepository;
import org.example.repositories.StudentsRepository;
import org.springframework.stereotype.Service;


import java.util.List;

import static org.example.dto.StudentDto.from;
import static org.example.dto.CourseDto.from;

@Service
@RequiredArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;
    private final CoursesRepository coursesRepository;


    @Override
    public List<StudentDto> getStudents() {
        return from(studentsRepository.findAll());
    }

    @Override
    public StudentDto addStudent(StudentDto student) {
        Student newStudent = Student.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();

        studentsRepository.save(newStudent);

        return from(newStudent);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto student) {
        Student maybeStudent = studentsRepository.getById(id);
        maybeStudent.setFirstName(student.getFirstName());
        maybeStudent.setFirstName(student.getLastName());
        studentsRepository.save(maybeStudent);
        return from(maybeStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student maybeStudent = studentsRepository.getById(id);
        maybeStudent.setIsDeleted(true);
        studentsRepository.save(maybeStudent);
    }

    @Override
    public List<CourseDto> addCourseToStudent(Long studentId, CourseDto course) {
        Student maybeStudent = studentsRepository.getById(studentId);
        Course maybeCourse = coursesRepository.getById(course.getId());
        maybeStudent.getCourses().add(maybeCourse);
        studentsRepository.save(maybeStudent);
        return from(maybeStudent.getCourses());
    }
}
