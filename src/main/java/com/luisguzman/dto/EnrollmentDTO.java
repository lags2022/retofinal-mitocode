package com.luisguzman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private LocalDateTime dateTime;

    @JsonIncludeProperties(value = {"idStudent","nameStudent","lastnameStudent"})
    @NotNull
    private StudentDTO student;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;

    @NotNull
    private boolean enabled;
}

