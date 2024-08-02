package com.luisguzman.service.impl;

import com.luisguzman.model.Student;
import com.luisguzman.repo.IStudentRepo;
import com.luisguzman.repo.IGenericRepo;
import com.luisguzman.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {
    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findAllOrderDesc() {
        return repo.findAll()
                .stream()
                .sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge())) // Ordenar por edad en orden descendente
                .toList();

        //Sort.Direction direction = Sort.Direction.DESC;
        //return repo.findAll(Sort.by(direction, "age"));
    }
}
