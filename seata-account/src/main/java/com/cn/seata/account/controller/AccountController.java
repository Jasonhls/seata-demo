package com.cn.seata.account.controller;

import com.cn.seata.account.pojo.Account;
import com.cn.seata.account.service.AccountService;
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
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/debit")
    public void debit(String userId, int money) {
        accountService.debit(userId, money);
    }

    @GetMapping(value = "/list")
    public List<Account> selectList() {
        return accountService.list();
    }
}
