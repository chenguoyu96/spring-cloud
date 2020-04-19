package org.chenguoyu.exceptions;

import org.chenguoyu.entity.Errors;

public class ApplicationException extends RuntimeException{
    /**
     * 自定义错误码
     */
    private Integer code;

    /**
     * 自定义构造器，只保留一个，让其必须输入错误码及内容
     */
    public ApplicationException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ApplicationException(Errors errors) {
        super(errors.getMessage());
        this.code = errors.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
