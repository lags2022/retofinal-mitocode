package com.luisguzman.service;

import com.luisguzman.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{
    List<Student> findAllOrderDesc();
}
