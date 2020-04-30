package org.chenguoyu.springcloud.consumer.controller;

import cn.hutool.core.collection.CollectionUtil;
import org.chenguoyu.entity.Result;
import org.chenguoyu.model.Payment;
import org.chenguoyu.springcloud.lb.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalance loadBalance;

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/payment/create")
    public Result<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, Result.class);
    }

    @GetMapping("/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);
    }

    /**
     * 不使用Ribbon进行轮询算法 记得注释掉restTemplate上的@LoadBalanced
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtil.isEmpty(instances)) {
            return null;
        }
        ServiceInstance instance = loadBalance.instance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lb", String.class);
    }
}
