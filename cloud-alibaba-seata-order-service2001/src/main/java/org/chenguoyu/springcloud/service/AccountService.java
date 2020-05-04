package org.chenguoyu.springcloud.service;

import org.chenguoyu.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 减余额
     *
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}

