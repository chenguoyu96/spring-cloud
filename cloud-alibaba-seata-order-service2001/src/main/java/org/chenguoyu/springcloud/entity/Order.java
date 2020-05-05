package org.chenguoyu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_order")
public class Order {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 产品id
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 数量
     */
    @TableField(value = "count")
    private Integer count;

    /**
     * 金额
     */
    @TableField(value = "money")
    private BigDecimal money;

    /**
     * 订单状态: 0创建中 1已完结
     */
    @TableField(value = "status")
    private Long status;
}