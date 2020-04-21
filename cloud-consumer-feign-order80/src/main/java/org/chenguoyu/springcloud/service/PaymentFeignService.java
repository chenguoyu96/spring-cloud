package org.chenguoyu.springcloud.service;

import org.chenguoyu.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {
    @GetMapping("/get/{id}")
    Result get(@PathVariable("id") Long id);

    @GetMapping(value = "/feign/timeout")
    String paymentFeignTimeOut();

}
