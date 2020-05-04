package org.chenguoyu.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.chenguoyu.springcloud.entity.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}