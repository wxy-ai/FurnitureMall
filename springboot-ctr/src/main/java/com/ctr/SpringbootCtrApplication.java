package com.ctr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Hashtable;

@SpringBootApplication
@MapperScan(basePackages = "com.ctr.dao")
public class SpringbootCtrApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootCtrApplication.class, args);
    }
}
