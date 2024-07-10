package com.cn.seata.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/18:07
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients(value = {"com.cn.seata.api"})
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
