package com.cn.seata.business.controller;

import com.cn.seata.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
@RestController
@RequestMapping(value = "/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("testRollback")
    public String testRollback() {
        try {
            businessService.purchaseRollback("U100001", "C00321", 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "testRollback failed";
        }
        return "testRollback success";
    }

    @GetMapping("testCommit")
    public String testCommit() {
        businessService.purchaseCommit("U100001", "C00321", 2);
        return "testCommit success";
    }
}
