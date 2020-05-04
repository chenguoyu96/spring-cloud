package org.chenguoyu.springcloud.service;

import org.chenguoyu.springcloud.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);
}
