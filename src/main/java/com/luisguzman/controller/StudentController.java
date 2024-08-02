package com.luisguzman.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luisguzman.dto.StudentDTO;
import com.luisguzman.dto.GenericResponse;
import com.luisguzman.model.Student;
import com.luisguzman.service.IStudentService;
import com.luisguzman.util.MapperUtil;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>> readAll() throws Exception {
        List<StudentDTO> list = mapperUtil.mapList(service.readAll(), StudentDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> readById(@PathVariable("id") int id) throws Exception {
        StudentDTO obj = mapperUtil.map(service.readById(id), StudentDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception {
        Student obj = service.save(mapperUtil.map(dto, Student.class));

        return new ResponseEntity<>(mapperUtil.map(obj, StudentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @PathVariable("id") int id, @RequestBody StudentDTO dto) throws Exception {
        Student obj = service.update(mapperUtil.map(dto, Student.class) , id);

        return ResponseEntity.ok(mapperUtil.map(obj, StudentDTO.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/desc")
    public ResponseEntity<GenericResponse<StudentDTO>> findAllOrderDesc() {
        List<StudentDTO> list = mapperUtil.mapList(service.findAllOrderDesc(), StudentDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }
}
