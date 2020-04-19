package org.chenguoyu.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.chenguoyu.model.Payment;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}