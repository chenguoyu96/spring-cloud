package org.chenguoyu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.chenguoyu.entity.Result;
import org.chenguoyu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public Result getServicePort(@PathVariable Long id) {
        return paymentFeignService.get(id);
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
