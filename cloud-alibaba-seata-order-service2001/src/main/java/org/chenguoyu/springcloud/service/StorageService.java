package org.chenguoyu.springcloud.service;

import org.chenguoyu.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-storage-service")
public interface StorageService {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}