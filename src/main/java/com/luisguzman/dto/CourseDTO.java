package com.luisguzman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameCourse;

    @NotNull
    @Size(min = 1, max = 2)
    private String acronymCourse;

    @NotNull
    private boolean enabledCourse;
}

