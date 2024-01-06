package com.olrando.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id; //ID
    private Integer no; //学号
    private String name; //学生姓名
    private Integer sex;// 性别
    private Integer age;//年龄
    private String address;//地址
    private String phone;//电话
    private String email;//邮箱
}
