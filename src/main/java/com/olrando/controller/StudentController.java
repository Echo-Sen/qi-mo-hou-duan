package com.olrando.controller;

import com.olrando.pojo.Result;
import com.olrando.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private com.olrando.service.StudentService StudentService;
    @GetMapping()
    public Result findAll(){
        log.info("查询全部学生信息");
        List<Student> StudentList = StudentService.findAll();
        return Result.success(StudentList);
    }

    @GetMapping("/{no}")
    public Result findByNo(@PathVariable Integer no){
        log.info("根据学号查询学生信息，学号：{}", no);
        Student Student = StudentService.findByNo(no);
        return Result.success(Student);
    }

    @PostMapping("/insert")
    public Result addStudent(@RequestBody  Student student){
        log.info("添加学生信息，学生信息：{}", student);
        StudentService.addStudent(student);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteStudent(@PathVariable Integer id){
        log.info("删除学生信息，id：{}", id);
        StudentService.deleteStudent(id);
        return Result.success();
    }


}
