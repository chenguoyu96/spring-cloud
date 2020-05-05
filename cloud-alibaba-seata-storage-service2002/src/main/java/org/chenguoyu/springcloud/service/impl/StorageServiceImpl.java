package org.chenguoyu.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

import org.chenguoyu.springcloud.entity.Storage;
import org.chenguoyu.springcloud.mapper.StorageMapper;
import org.chenguoyu.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("----> storage-service中扣减库存结束");
    }
}
