package com.cn.seata.storage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: 何立森
 * @Date: 2024/07/09/17:46
 * @Description:
 */
@TableName(value = "stock_tbl")
@Data
public class Storage {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField(value = "commodity_code")
    private String commodityCode;
    @TableField(value = "count")
    private Integer count;
}
