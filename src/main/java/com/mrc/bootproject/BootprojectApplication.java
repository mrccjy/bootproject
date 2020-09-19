package com.mrc.bootproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.mrc.bootproject.mapper")
@SpringBootApplication(scanBasePackages = "com.mrc.bootproject")
public class BootprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootprojectApplication.class, args);
    }

}
