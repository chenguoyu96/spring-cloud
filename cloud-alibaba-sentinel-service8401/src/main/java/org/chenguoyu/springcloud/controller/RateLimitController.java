package org.chenguoyu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.chenguoyu.entity.Result;
import org.chenguoyu.model.Payment;
import org.chenguoyu.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-25 15:04
 */
@RestController
public class RateLimitController {
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public Result byUrl() {
        return new Result(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Result byResource() {
        return new Result(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public Result handleException(BlockException exception) {
        return Result.error(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public Result customerBlockHandler() {
        return new Result(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}