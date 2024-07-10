package com.cn.seata.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.seata.api.AccountFeign;
import com.cn.seata.order.mapper.OrderMapper;
import com.cn.seata.order.pojo.Order;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.Objects;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AccountFeign accountFeign;

    @Override
    public void create(String userId, String commodityCode, int orderCount) {
        log.info("Order Service Begin ... xid: " + RootContext.getXID());

        // 计算订单金额
        int orderMoney = calculate(commodityCode, orderCount);

        // 从账户余额扣款
        accountFeign.debit(userId, orderMoney);

        log.info(
                "Order Service SQL: insert into order_tbl (user_id, commodity_code, count, money) values ({}, {}, {}, {})",
                userId, commodityCode, orderCount, orderMoney);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement pst = con.prepareStatement(
                    "insert into order_tbl (user_id, commodity_code, count, money) values (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setObject(1, userId);
            pst.setObject(2, commodityCode);
            pst.setObject(3, orderCount);
            pst.setObject(4, orderMoney);
            return pst;
        }, keyHolder);


        log.info("Order Service End ... Created " + Objects.requireNonNull(keyHolder.getKey()).longValue());
    }

    private int calculate(String commodityId, int orderCount) {
        return 200 * orderCount;
    }
}
