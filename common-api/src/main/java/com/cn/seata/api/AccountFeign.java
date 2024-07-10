package com.cn.seata.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 何立森
 * @Date: 2024/07/10/8:39
 * @Description:
 */
@FeignClient(name = "seata-account", contextId = "accountFeign", path = "/account")
public interface AccountFeign {

    @GetMapping(value = "/debit")
    void debit(@RequestParam(required = false) String userId, @RequestParam(required = false) int money);
}
