package com.olrando.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
/**
 * 班级实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private Integer id; //ID
    private String name; //班级名称
    private Integer deptId; //学院ID
    private Integer monitorId; //班长ID
    private Integer counselorId; //辅导员ID
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
