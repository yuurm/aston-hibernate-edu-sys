package org.example.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class Lesson {
    private Long id;
    private String name;

    //Many-To-One
    private Course course;

}
