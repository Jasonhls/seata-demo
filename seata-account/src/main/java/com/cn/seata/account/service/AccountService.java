package com.cn.seata.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.seata.account.pojo.Account;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
public interface AccountService extends IService<Account> {

    /**
     * 从用户账户中借出
     * @param userId
     * @param money
     */
    void debit(String userId, int money);
}
