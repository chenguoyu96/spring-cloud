package org.chenguoyu.springcloud.oauth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 
  * @author 陈国钰 on 2020-7-8.
  * @version 1.0
  */
@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("/findAll")
    public String findAll(){
        return "产品列表查询成功！";
    }
}
