package org.chenguoyu.springcloud.oauth.server.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
  * 
  * @author 陈国钰 on 2020-7-8.
  * @version 1.0
  */
@Data
public class SysRole implements GrantedAuthority {
    private Integer id;
    private String roleName;
    private String roleDesc;
    @Override
    public String getAuthority() {
        return roleName;
    }
}
