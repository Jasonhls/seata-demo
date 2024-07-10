package com.cn.seata.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.seata.order.pojo.Order;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
public interface OrderService extends IService<Order> {
    /**
     * 创建订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    void create(String userId, String commodityCode, int orderCount);
}
