package org.chenguoyu.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chenguoyu.springcloud.entity.Storage;

public interface StorageService extends IService<Storage> {
    void decrease(Long productId, Integer count);

}
