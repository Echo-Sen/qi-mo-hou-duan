package com.olrando.service.impl;

import com.olrando.anno.Log;
import com.olrando.mapper.EmpMapper;
import com.olrando.pojo.Dept;
import com.olrando.pojo.DeptLog;
import com.olrando.service.DeptLogService;
import com.olrando.service.DeptService;
import com.olrando.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

//部门业务实现类
@Slf4j
@Service
//@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    @Log
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Log
    public void add(Dept aDept) {
        //补全部门数据
        aDept.setCreateTime(LocalDateTime.now());
        aDept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(aDept);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @Log
    public void delete(Integer id) {
        try {
            //根据部门id删除部门信息
            deptMapper.deleteById(id);

            //删除部门下的所有员工信息\
            empMapper.deleteByDeptId(id);
        } finally {
            //不论是否有异常，最终都要执行的代码：记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是" + id + "号部门额");
            //调用其他业务类的方法
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public Dept find(Integer id){
        return  deptMapper.findById(id);
    }

    @Override
    public  void update(Dept aDept){
    aDept.setUpdateTime(LocalDateTime.now());
    deptMapper.update(aDept);
    }
}
