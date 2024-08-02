package com.luisguzman.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {

    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull
    @JsonIncludeProperties(value = {"idCourse","nameCourse"})
    private CourseDTO course;

    @NotNull
    @Size(min = 2, max = 50)
    private String classroom;
}

