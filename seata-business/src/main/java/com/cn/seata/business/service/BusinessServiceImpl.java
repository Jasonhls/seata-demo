package com.cn.seata.business.service;

import com.cn.seata.api.OrderFeign;
import com.cn.seata.api.StorageFeign;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/18:09
 * @Description:
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    private OrderFeign orderFeign;
    @Autowired
    private StorageFeign storageFeign;


    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-dubbo-tx")
    public void purchaseRollback(String userId, String commodityCode, int orderCount) {
        log.info("purchase begin ... xid: " + RootContext.getXID());
        storageFeign.deduct(commodityCode, orderCount);
        // just test batch update
        //stockService.batchDeduct(commodityCode, orderCount);
        orderFeign.create(userId, commodityCode, orderCount);
//        if (random.nextBoolean()) {
//            throw new RuntimeException("random exception mock!");
//        }
        throw new RuntimeException("random exception mock!");
    }

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-dubbo-tx")
    public void purchaseCommit(String userId, String commodityCode, int orderCount) {
        log.info("purchase begin ... xid: " + RootContext.getXID());
        storageFeign.deduct(commodityCode, orderCount);
        // just test batch update
        //stockService.batchDeduct(commodityCode, orderCount);
        orderFeign.create(userId, commodityCode, orderCount);
    }
}
