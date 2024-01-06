package com.olrando.service.impl;

import com.olrando.pojo.Student;
import com.olrando.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private com.olrando.mapper.StudentMapper StudentMapper;
    @Override
    public List<Student> findAll(){
        return StudentMapper.list();
    }
    public Student findByNo(Integer no){
        return StudentMapper.findByNo(no);
    }
    public void addStudent(Student Student){
        StudentMapper.addStudent(Student);
    }
    public void deleteStudent(Integer id){
        StudentMapper.deleteStudent(id);
    }
}
