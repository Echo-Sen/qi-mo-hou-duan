package com.olrando.service;

import com.olrando.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询所有的部门数据
     *
     * @return 存储Dept对象的集合
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept aDept);

    /**
     * 根据id查找部门信息
     *
     * @param id 部门id
     * @return 部门信息
     */
    Dept find(Integer id);

    /**
     * 更新部门信息
     *
     * @param aDept 新的部门信息
     */
    void update(Dept aDept);
}
