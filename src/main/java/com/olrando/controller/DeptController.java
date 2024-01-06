package com.olrando.controller;

import com.olrando.pojo.Dept;
import com.olrando.pojo.Result;
import com.olrando.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
//将全部以 /dept 开头的接口统一在此处
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */

    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        //调用service查询部门数据
        List<Dept> deptList =  deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
//        调用service层功能
        deptService.delete(id);
        return Result.success();
    }
    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept aDept){
        log.info("新增部门：{}", aDept);
        deptService.add(aDept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id){
        Dept aDept =  deptService.find(id);
        return Result.success(aDept);
    }

    @PutMapping
    public Result update(@RequestBody Dept aDept){
        deptService.update(aDept);
        return Result.success();
    }
}
