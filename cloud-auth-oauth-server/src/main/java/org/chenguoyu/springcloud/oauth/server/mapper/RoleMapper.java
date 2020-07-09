package org.chenguoyu.springcloud.oauth.server.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.chenguoyu.springcloud.oauth.server.entity.SysRole;

import java.util.List;
@Mapper
public interface RoleMapper{

    @Select("SELECT r.id, r.role_name roleName, r.role_desc roleDesc " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE r.id=ur.rid AND ur.uid=#{uid}")
    List<SysRole> findByUid(Integer uid);
}
