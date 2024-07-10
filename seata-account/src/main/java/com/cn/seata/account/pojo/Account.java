package com.cn.seata.account.pojo;

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
@TableName(value = "account_tbl")
@Data
public class Account {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "money")
    private Integer money;
}
