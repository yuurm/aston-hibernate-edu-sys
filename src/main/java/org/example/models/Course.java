package org.example.models;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "students")
public class Course {
    private Long id;
    private String title;

    //One-To-Many
    private List<Lesson> lessons;

    //Many-To-Many
    private List<Student> students;

}
