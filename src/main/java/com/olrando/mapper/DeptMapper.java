package com.olrando.mapper;

import com.olrando.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    //查询所有部门数据
//    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门数据
     */
//    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //    新增部门
//    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept aDept);

    Dept findById(Integer id);

    void update(Dept aDept);
}
