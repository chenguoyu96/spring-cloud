package org.chenguoyu.payment.controller;

import org.chenguoyu.model.Payment;
import org.chenguoyu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment) {
        paymentService.save(payment);
        return payment;
    }

    @GetMapping("/get/{id}")
    public Payment get(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
