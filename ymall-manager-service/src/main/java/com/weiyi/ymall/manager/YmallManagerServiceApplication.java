package com.weiyi.ymall.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.weiyi.ymall.manager")
public class YmallManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmallManagerServiceApplication.class, args);
    }

}
