package org.chenguoyu.entity;


import lombok.Data;

/**
 * 返回结果封装
 *
 * @author liux
 * @Title: Result
 * @Package com.ffcs.dcoos.api.dto
 * @date 2018/12/10 16:47
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class Result<T> {
    /**
     * 返回代码
     */
    private Integer code;
    /**
     * token
     */
    private String token;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }


    private Result(Errors message) {
        this.code = message.getCode();
        this.success = false;
        this.message = message.getMessage();
    }

    private Result(Integer code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.success = true;
        this.message = message;
        this.data = null;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.success = true;
        this.message = message;
        this.data = data;
    }

    private Result(Integer code, boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result success(T data) {
        return new Result<T>(200, true, "执行成功", data);
    }

    public static <T> Result success() {
        return new Result<T>(200, true, "执行成功");
    }

    public static Result error(Errors message) {
        return new Result(message);
    }

    public static Result error(String message) {
        return new Result(0, false, message);
    }

    public static Result error(int code, String message) {
        return new Result(code, false, message);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }
}