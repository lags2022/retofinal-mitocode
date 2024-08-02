package com.luisguzman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameStudent;

    @NotNull
    @Size(min = 3, max = 50)
    private String lastnameStudent;

    @NotNull
    @Size(min = 3, max = 10)
    private String dniStudent;

    @NotNull
    @Min(value=1)
    @Max(value=99)
    private int ageStudent;
}

