package org.chenguoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Main.class);
    }
}
