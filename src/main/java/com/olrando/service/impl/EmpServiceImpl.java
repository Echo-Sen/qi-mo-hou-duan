package com.olrando.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.olrando.anno.Log;
import com.olrando.mapper.EmpMapper;
import com.olrando.pojo.Emp;
import com.olrando.pojo.PageBean;
import com.olrando.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //分页查询
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        //获取分页结果
        Page<Emp> p = (Page<Emp>) empList;
        //3.封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    @Log
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    @Log
    public void save(Emp emp) {
        // 补全数据
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        // 调用添加方法
        empMapper.insert(emp);
    }
    @Override
    @Log
    public Emp getById(Integer id){
        return empMapper.findById(id);
    }

    @Override
    @Log
    public void update(Emp emp){
//        更新为当前时间
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
    @Override
    public Emp login(Emp emp){
        return empMapper.getByUsernameAndPassword(emp);
    }
}
