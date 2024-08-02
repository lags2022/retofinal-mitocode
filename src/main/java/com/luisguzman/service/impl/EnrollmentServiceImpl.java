package com.luisguzman.service.impl;

import com.luisguzman.model.Enrollment;
import com.luisguzman.model.Student;
import com.luisguzman.repo.IGenericRepo;
import com.luisguzman.repo.IEnrollmentRepo;
import com.luisguzman.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {
    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<Student>> getStudentsByCourseEnrollment() {
        return repo.findAll()
                .stream()
                .flatMap(enrollment -> enrollment.getDetails()
                        .stream()
                        .map(detail -> new AbstractMap.SimpleEntry<>(detail.getCourse().getName(), enrollment.getStudent())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
