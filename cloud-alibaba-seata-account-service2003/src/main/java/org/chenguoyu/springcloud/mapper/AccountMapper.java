package org.chenguoyu.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.chenguoyu.springcloud.entity.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 扣减账户余额
     *
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}