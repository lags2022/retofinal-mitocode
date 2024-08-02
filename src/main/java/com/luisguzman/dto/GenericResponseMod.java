package com.luisguzman.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.luisguzman.model.Student;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GenericResponseMod<T>(
        int status,
        String message,
        T data
) {
}