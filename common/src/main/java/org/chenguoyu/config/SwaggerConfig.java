package org.chenguoyu.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger-ui的配置文件
 * 可以使用
 * http://ip-address:port/doc.html
 * doc.html
 * http://ip-address:port/swagger-ui.html
 * 访问接口文档
 *
 * @author liux
 * @Title: SwaggerConfig
 * @Package com.ffcs.dcoos.api.config
 * @date 2018/12/10 15:40
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
    }
}
