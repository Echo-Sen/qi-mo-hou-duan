package com.olrando.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudentCourseController {
    @Autowired
    private com.olrando.service.StudentCourseService studentCourseService;
    @PostMapping("/sc")
    public com.olrando.pojo.Result findAll(){
        log.info("查询全部学生课程信息");
        java.util.List<com.olrando.pojo.StudentCourse> studentCourseList = studentCourseService.findAll();
        return com.olrando.pojo.Result.success(studentCourseList);
    }
}
