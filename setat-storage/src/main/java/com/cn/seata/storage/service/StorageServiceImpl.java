package com.cn.seata.storage.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.seata.storage.mapper.StorageMapper;
import com.cn.seata.storage.pojo.Storage;
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
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deduct(String commodityCode, int count) {
        log.info("Stock Service Begin ... xid: " + RootContext.getXID());
        log.info("Deducting inventory SQL: update stock_tbl set count = count - {} where commodity_code = {}", count,
                commodityCode);

        jdbcTemplate.update("update stock_tbl set count = count - ? where commodity_code = ?",
                count, commodityCode);
        log.info("Stock Service End ... ");

    }
}
