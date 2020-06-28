/**
 * Copyright (C), 2019-2019, murata
 * FileName: MybatisPlusConfig
 * Author:   WME19741
 * Date:     2019/09/16.8:50
 * Description: MybatisPlusConfig
 * History:
 * <author>         <time>          <version>           <desc>
 * 作者姓名         修改时间        版本号               描述
 */
package com.yunmi.app.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * {功能描述}<br>
 *
 * @aurhor liuyw
 * @create 2019/08/20
 * @since 1.0.0
 */
@Configuration
@MapperScan({"com.yunmi.app.mapper.*.mapper"})
public class MybatisPlusConfig {

    /**
     * 1.分页插件
     * 2.多租户
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        return paginationInterceptor;
    }

    /**
     * SQL 执行效率插件
     * 设置 dev 环境开启
     * @return
     */
    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
