package com.cn.seata.storage.controller;

import com.cn.seata.storage.pojo.Storage;
import com.cn.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
@RestController
@RequestMapping(value = "/storage")
@EnableFeignClients
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping(value = "/deduct")
    public void deduct(String commodityCode, int count) {
        storageService.deduct(commodityCode, count);
    }

    @GetMapping(value = "/list")
    public List<Storage> selectList() {
        return storageService.list();
    }
}
