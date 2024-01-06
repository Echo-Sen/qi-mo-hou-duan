package com.olrando.service;

import com.olrando.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 查询所有学生信息
     *
     * @return 存储Student对象的集合
     */

    List<Student> findAll();

    /**
     * 根据学号查询学生信息
     *
     * @param no 学号
     * @return 学生对象
     */
    Student findByNo(Integer no);

    /**
     * 添加学生信息
     */
    void addStudent(Student student);

    /**
     * 删除学生信息
     */
    void deleteStudent(Integer id);
}
