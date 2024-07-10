package com.cn.seata.account.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.seata.account.mapper.AccountMapper;
import com.cn.seata.account.pojo.Account;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void debit(String userId, int money) {
        log.info("Account Service ... xid: " + RootContext.getXID());
        log.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}", money,
                userId);

        jdbcTemplate.update("update account_tbl set money = money - ? where user_id = ?", new Object[]{money, userId});
        log.info("Account Service End ... ");
    }
}
