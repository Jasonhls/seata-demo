package com.cn.seata.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.seata.storage.pojo.Storage;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:47
 * @Description:
 */
public interface StorageService extends IService<Storage> {

    /**
     * 扣除存储数量
     * @param commodityCode
     * @param count
     */
    void deduct(String commodityCode, int count);
}
