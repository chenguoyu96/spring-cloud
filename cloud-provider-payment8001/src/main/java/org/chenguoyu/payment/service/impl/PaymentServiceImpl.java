package org.chenguoyu.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chenguoyu.model.Payment;
import org.chenguoyu.payment.mapper.PaymentMapper;
import org.chenguoyu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
}
