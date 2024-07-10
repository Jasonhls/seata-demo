package com.cn.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:31
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = "com.cn.seata.order.mapper")
@EnableFeignClients(value = {"com.cn.seata.api"})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
