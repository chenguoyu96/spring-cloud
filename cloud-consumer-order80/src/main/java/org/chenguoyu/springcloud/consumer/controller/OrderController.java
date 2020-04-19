package org.chenguoyu.springcloud.consumer.controller;

import org.chenguoyu.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/payment/create")
    public Payment create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, Payment.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Payment.class);
    }
}
