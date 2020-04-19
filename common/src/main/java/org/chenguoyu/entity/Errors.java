package org.chenguoyu.entity;


public enum Errors {

    /**
     * 未知错误
     */
    UNKNOW_ERROR(500, "未知错误"),
    /**
     * 未找到该用户
     */
    ACCOUNT_ERROR(500, "未找到该用户"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR(500, "密码错误"),
    /**
     * 服务器异常，请联系管理员
     */
    SERVER_ERROR(500, "服务器异常，请联系管理员"),


    ;

    private Integer code;
    private String message;

    Errors(Integer code, String message) {
        this.code = code;

        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
