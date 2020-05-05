package org.chenguoyu.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chenguoyu.springcloud.entity.Account;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {

    void decrease(Long userId, BigDecimal money);
}
