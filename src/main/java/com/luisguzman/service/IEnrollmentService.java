package com.luisguzman.service;

import com.luisguzman.model.Enrollment;
import com.luisguzman.model.Student;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer>{
    Map<String, List<Student>> getStudentsByCourseEnrollment();
}
