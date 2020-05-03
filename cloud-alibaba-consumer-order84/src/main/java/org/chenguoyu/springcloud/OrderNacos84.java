package org.chenguoyu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacos84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacos84.class);
    }
}
