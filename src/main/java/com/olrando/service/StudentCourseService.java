package com.olrando.service;

import com.olrando.pojo.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    /**
     * 查询所有学生-成绩信息
     */
    List<StudentCourse> findAll();
}
