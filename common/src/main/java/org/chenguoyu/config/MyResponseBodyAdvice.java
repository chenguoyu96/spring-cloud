package org.chenguoyu.config;

import lombok.extern.slf4j.Slf4j;
import org.chenguoyu.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("NullableProblems")
@ControllerAdvice("org.chenguoyu")
@Slf4j
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static Set<Class> excludeType = new HashSet<>();

    static {
        excludeType.add(Result.class);
        excludeType.add(File.class);
        excludeType.add(ResponseEntity.class);
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) {
            return Result.success();
        }

        if (isExclude(body)) {
            return body;
        } else {
            log.debug("返回类型:{}返回值:{}", body.getClass().getName(), body.toString());
            return Result.success(body);
        }
    }

    private boolean isExclude(Object obj) {
        return excludeType.contains(obj.getClass());
    }
}