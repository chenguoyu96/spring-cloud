package org.chenguoyu.springcloud.controller;

import org.chenguoyu.entity.Result;
import org.chenguoyu.springcloud.entity.Order;
import org.chenguoyu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public Result create(Order order) {
        orderService.create(order);
        return new Result(200, "订单创建成功");
    }

}
