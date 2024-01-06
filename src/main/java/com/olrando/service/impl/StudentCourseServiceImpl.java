package com.olrando.service.impl;

import com.olrando.anno.Log;
import com.olrando.pojo.StudentCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentCourseServiceImpl implements com.olrando.service.StudentCourseService {
    @Autowired
    private com.olrando.mapper.StudentCourseMapper studentCourseMapper;

    @Override
    @Log
    public List<StudentCourse> findAll() {
        return studentCourseMapper.findAll();
    }
}
