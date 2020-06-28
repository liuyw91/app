package com.yunmi.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement    // 启用事务
@EnableCaching                  // 启用缓存
@EnableScheduling
@MapperScan(basePackages = {"com.yunmi.app.mapper.*"})
public class AppApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
