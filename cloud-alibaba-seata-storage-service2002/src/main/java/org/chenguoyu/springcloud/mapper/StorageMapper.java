package org.chenguoyu.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.chenguoyu.springcloud.entity.Storage;

public interface StorageMapper extends BaseMapper<Storage> {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);


}