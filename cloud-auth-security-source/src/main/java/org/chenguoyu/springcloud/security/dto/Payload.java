package org.chenguoyu.springcloud.security.dto;

import lombok.Data;

import java.util.Date;


@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}