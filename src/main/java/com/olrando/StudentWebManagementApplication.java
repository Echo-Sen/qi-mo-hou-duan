package com.olrando;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //开启servlet支持
@SpringBootApplication
public class StudentWebManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentWebManagementApplication.class, args);
    }
}
