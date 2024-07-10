package com.cn.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:44
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = "com.cn.seata.account.mapper")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
