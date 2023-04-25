package org.example.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsResponse {
    private List<StudentDto> data;
}
