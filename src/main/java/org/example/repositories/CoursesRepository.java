package org.example.repositories;

import org.example.models.Course;

public interface CoursesRepository  {
    Course getById(Long id);
}
