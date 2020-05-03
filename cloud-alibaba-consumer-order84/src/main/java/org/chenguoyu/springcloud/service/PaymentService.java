package org.chenguoyu.springcloud.service;


import org.chenguoyu.entity.Result;
import org.chenguoyu.model.Payment;
import org.chenguoyu.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
    Result<Payment> paymentSQL(@PathVariable("id") Long id);
}
