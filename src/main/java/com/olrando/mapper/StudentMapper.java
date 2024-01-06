package com.olrando.mapper;

import com.olrando.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper {
    @Select("select * from student;")
    List<Student> list();

    Student findByNo(Integer no);

    void addStudent(Student student);

    void deleteStudent(Integer id);
}
