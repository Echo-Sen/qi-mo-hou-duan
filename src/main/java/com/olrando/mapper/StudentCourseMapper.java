package com.olrando.mapper;

import com.olrando.pojo.StudentCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentCourseMapper {
    /**
     * 查询所有学生-成绩信息
     */
    List<StudentCourse> findAll();
}
