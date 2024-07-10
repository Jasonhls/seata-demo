package com.cn.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:42
 * @Description:
 */
@SpringBootApplication
@MapperScan(value = "com.cn.seata.storage.mapper")
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }
}
