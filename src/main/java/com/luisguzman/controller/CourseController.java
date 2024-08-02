package com.luisguzman.controller;

import com.luisguzman.dto.GenericResponse;
import com.luisguzman.dto.CourseDTO;
import com.luisguzman.model.Course;
import com.luisguzman.service.ICourseService;
import com.luisguzman.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<CourseDTO>> readAll() throws Exception {
        List<CourseDTO> list = mapperUtil.mapList(service.readAll(), CourseDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> readById(@PathVariable("id") int id) throws Exception {
        CourseDTO obj = mapperUtil.map(service.readById(id), CourseDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception {
        Course obj = service.save(mapperUtil.map(dto, Course.class));

        return new ResponseEntity<>(mapperUtil.map(obj, CourseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @PathVariable("id") int id, @RequestBody CourseDTO dto) throws Exception {
        Course obj = service.update(mapperUtil.map(dto, Course.class) , id);

        return ResponseEntity.ok(mapperUtil.map(obj, CourseDTO.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
