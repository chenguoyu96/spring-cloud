package org.chenguoyu.payment.controller;

import org.chenguoyu.model.Payment;
import org.chenguoyu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment) {
        paymentService.save(payment);
        return payment;
    }

    @GetMapping("/get/{id}")
    public Payment get(@PathVariable Long id) {
        return paymentService.getById(id);
    }
}
