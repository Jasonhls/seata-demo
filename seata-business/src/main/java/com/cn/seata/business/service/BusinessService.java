package com.cn.seata.business.service;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/18:09
 * @Description:
 */
public interface BusinessService {

    /**
     * 用户订购商品回滚
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    void purchaseRollback(String userId, String commodityCode, int orderCount);

    /**
     * 用户订购商品成功
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    void purchaseCommit(String userId, String commodityCode, int orderCount);
}
