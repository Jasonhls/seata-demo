package com.cn.seata.order.controller;

import com.cn.seata.order.pojo.Order;
import com.cn.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/create")
    public void create(String userId, String commodityCode, int orderCount) {
        orderService.create(userId, commodityCode, orderCount);
    }

    @GetMapping(value = "/list")
    public List<Order> selectList() {
        return orderService.list();
    }
}
