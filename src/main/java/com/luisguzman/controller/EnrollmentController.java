package com.luisguzman.controller;

import com.luisguzman.dto.GenericResponse;
import com.luisguzman.dto.EnrollmentDTO;
import com.luisguzman.dto.GenericResponseMod;
import com.luisguzman.dto.StudentDTO;
import com.luisguzman.model.Enrollment;
import com.luisguzman.model.Student;
import com.luisguzman.service.IEnrollmentService;
import com.luisguzman.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final IEnrollmentService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<EnrollmentDTO>> readAll() throws Exception {
        List<EnrollmentDTO> list = mapperUtil.mapList(service.readAll(), EnrollmentDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollmentDTO>> readById(@PathVariable("id") int id) throws Exception {
        EnrollmentDTO obj = mapperUtil.map(service.readById(id), EnrollmentDTO.class);

        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO dto) throws Exception {
        Enrollment obj = service.save(mapperUtil.map(dto, Enrollment.class));

        return new ResponseEntity<>(mapperUtil.map(obj, EnrollmentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @PathVariable("id") int id, @RequestBody EnrollmentDTO dto) throws Exception {
        Enrollment obj = service.update(mapperUtil.map(dto, Enrollment.class) , id);

        return ResponseEntity.ok(mapperUtil.map(obj, EnrollmentDTO.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/course-students")
    public ResponseEntity<GenericResponseMod<Map<String, List<StudentDTO>>>> getStudentsByCourseEnrollment() {
        Map<String, List<Student>> studentsByCoursesEnrollments = service.getStudentsByCourseEnrollment();

        Map<String, List<StudentDTO>> mappedStudents = mapperUtil.mapMap(studentsByCoursesEnrollments, StudentDTO.class);

        return ResponseEntity.ok(new GenericResponseMod<>(200, "success", mappedStudents));
    }
}
