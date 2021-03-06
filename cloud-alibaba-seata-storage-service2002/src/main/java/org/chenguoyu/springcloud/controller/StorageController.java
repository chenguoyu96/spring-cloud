package org.chenguoyu.springcloud.controller;

import org.chenguoyu.entity.Result;
import org.chenguoyu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public Result decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new Result(200, "扣减库存成功!");
    }
}
