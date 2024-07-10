package com.cn.seata.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cn.seata.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:48
 * @Description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
