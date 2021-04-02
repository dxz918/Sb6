package com.turing.sb6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.turing.sb6.mapper")//扫描mapper接口并放入容器中
public class Sb6Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb6Application.class, args);
    }

}
