package com.luisguzman.service.impl;

import com.luisguzman.model.Course;
import com.luisguzman.repo.IGenericRepo;
import com.luisguzman.repo.ICourseRepo;
import com.luisguzman.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {
    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }    
}
