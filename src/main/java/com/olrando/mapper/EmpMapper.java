package com.olrando.mapper;

import com.olrando.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    //批量删除
    void delete(List<Integer> ids);

    //增加员工
    void insert(Emp emp);

    //根据id查询员工
    Emp findById(Integer id);

    //更新员工
    void update(Emp emp);
    // 账号密码登录
    Emp getByUsernameAndPassword(Emp emp);

    /**
     * 根据id删除部门信息
     * @param deptId 部门id
     */

    void deleteByDeptId(Integer deptId);
}
