package org.chenguoyu.springcloud.security.config;


import org.chenguoyu.springcloud.security.filter.TokenVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) // 开启权限注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RsaKeyProperties prop;

    /**
     * SpringSecurity配置信息
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // 关闭跨站请求防护
                .cors().and().csrf().disable()
                // 允许不登录就可以访问的方法, 多个用逗号分隔
                .authorizeRequests().antMatchers("/product").hasAnyRole("USER")
                // 其他的需要授权后访问
                .anyRequest().authenticated()
                .and()
                // 增加自定义验证认证过滤器
                .addFilter(new TokenVerifyFilter(super.authenticationManager(), prop))
                // 前后端分离是无状态的,禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
