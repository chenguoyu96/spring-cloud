package org.chenguoyu.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chenguoyu.springcloud.entity.Order;

public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);
}
