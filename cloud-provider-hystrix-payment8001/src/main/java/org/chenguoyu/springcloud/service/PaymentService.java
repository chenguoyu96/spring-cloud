package org.chenguoyu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程名称: " + Thread.currentThread().getName() + " PaymentInfo_OK,id:" + id;
    }

    /**
     * 服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int seconds = 3;
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程名称: " + Thread.currentThread().getName() + " PaymentInfo_TimeOut,id" + id + " 耗时:" + seconds + "秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程名称: " + Thread.currentThread().getName() + " 8001系统繁忙系统报错,请稍后再试id: " + id;
    }
}
