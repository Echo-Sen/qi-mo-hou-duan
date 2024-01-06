package com.olrando.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourse {
    private String studentName;
    private Integer no;
    private String sex;
    private String courseName;
    private Integer grade; //grade
}
