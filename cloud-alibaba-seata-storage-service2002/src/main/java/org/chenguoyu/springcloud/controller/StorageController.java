package org.chenguoyu.springcloud.controller;

import org.chenguoyu.entity.Result;
import org.chenguoyu.springcloud.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new Result(200, "扣减库存成功!");
    }
}
