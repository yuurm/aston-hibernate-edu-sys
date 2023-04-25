package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.CourseDto;
import org.example.dto.CoursesResponse;
import org.example.dto.StudentDto;
import org.example.dto.StudentsResponse;
import org.example.models.Student;
import org.example.service.StudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
//add url path
@RequestMapping("/students")
public class StudentsController  {

    private final StudentsService studentsService;

    @GetMapping("")
    public List<StudentDto> getStudents() {
        return studentsService.getStudents();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto addStudent(@RequestBody StudentDto student){
        return studentsService.addStudent(student);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDto updateStudent(@PathVariable("student-id") Long id, @RequestBody StudentDto student){
        return studentsService.updateStudent(id, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("student-id") Long id){
        studentsService.deleteStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{student-id}/courses")
    public CoursesResponse addCourseToStudent(@PathVariable("student-id") Long studentId, @RequestBody CourseDto course) {
        return CoursesResponse.builder()
                .data(studentsService.addCourseToStudent(studentId, course))
                .build();
    }

}






