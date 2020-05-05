package org.chenguoyu.springcloud.controller;

import org.chenguoyu.entity.Result;
import org.chenguoyu.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account/decrease")
    public Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new Result(200, "扣减账户余额成功！");
    }
}
