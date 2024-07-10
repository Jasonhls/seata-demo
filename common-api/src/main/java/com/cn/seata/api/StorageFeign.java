package com.cn.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 何立森
 * @Date: 2024/07/10/8:39
 * @Description:
 */
@FeignClient(name = "seata-storage", contextId = "storageFeign", path = "/storage")
public interface StorageFeign {

    @GetMapping(value = "/deduct")
    void deduct(@RequestParam(required = false) String commodityCode, @RequestParam(required = false) int count);
}
