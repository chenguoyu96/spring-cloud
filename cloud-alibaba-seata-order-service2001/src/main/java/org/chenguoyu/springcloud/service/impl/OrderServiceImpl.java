package org.chenguoyu.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.chenguoyu.springcloud.entity.Order;
import org.chenguoyu.springcloud.mapper.OrderMapper;
import org.chenguoyu.springcloud.service.AccountService;
import org.chenguoyu.springcloud.service.OrderService;
import org.chenguoyu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     *
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        // 1 新建订单
        log.info("----->开始新建订单");
        order.setStatus(0L);
        orderMapper.insert(order);

        // 2 扣减库存
        log.info("----->订单微服务开始调用库存,做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存,做扣减End");

        // 3 扣减账户
        log.info("----->订单微服务开始调用账户,做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减End");

        // 4 修改订单状态,从0到1,1代表已完成
        log.info("----->修改订单状态开始");
        orderMapper.updateStatus(order.getUserId(), 1);

        log.info("----->下订单结束了,O(∩_∩)O哈哈~");
    }
}
