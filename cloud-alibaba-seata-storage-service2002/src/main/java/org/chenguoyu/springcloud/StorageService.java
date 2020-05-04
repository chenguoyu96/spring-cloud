package org.chenguoyu.springcloud;

import org.chenguoyu.springcloud.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface StorageService extends IService<Storage> {
    void decrease(Long productId, Integer count);

}
