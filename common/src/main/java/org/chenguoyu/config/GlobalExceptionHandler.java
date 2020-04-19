package org.chenguoyu.config;



import org.chenguoyu.entity.Errors;
import org.chenguoyu.entity.Result;
import org.chenguoyu.exceptions.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus
    public Result defultExcepitonHandler(ApplicationException e) {
        e.printStackTrace();
        return Result.error(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus
    public Result defultExcepitonHandler(RuntimeException e) {
        e.printStackTrace();
        return Result.error(Errors.UNKNOW_ERROR);
    }
}
