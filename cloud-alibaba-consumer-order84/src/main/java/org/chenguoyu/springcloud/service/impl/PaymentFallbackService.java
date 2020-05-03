package org.chenguoyu.springcloud.service.impl;


import org.chenguoyu.entity.Result;
import org.chenguoyu.model.Payment;
import org.chenguoyu.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public Result<Payment> paymentSQL(Long id) {
        return new Result<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
