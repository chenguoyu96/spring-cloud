package org.chenguoyu.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.chenguoyu.springcloud.service.AccountService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chenguoyu.springcloud.entity.Account;
import org.chenguoyu.springcloud.mapper.AccountMapper;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {


    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----> account-service中扣减用户余额开始");
        accountMapper.decrease(userId, money);
        log.info("----> account-service中扣减用户余额开始");
    }
}
