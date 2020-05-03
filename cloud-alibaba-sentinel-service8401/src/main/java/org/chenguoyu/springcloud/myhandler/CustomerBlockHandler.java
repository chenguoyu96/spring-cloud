package org.chenguoyu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.chenguoyu.entity.Result;

/**
 * 全局设定限流异常返回
 */
public class CustomerBlockHandler {
    public static Result handlerException(BlockException exception) {
        return Result.error(4444, "按客戶自定义,global handlerException----1");
    }

    public static Result handlerException2(BlockException exception) {
        return Result.error(4444, "按客戶自定义,global handlerException----2");
    }
}
