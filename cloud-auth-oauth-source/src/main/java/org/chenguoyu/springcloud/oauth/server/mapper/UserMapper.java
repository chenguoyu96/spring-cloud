package org.chenguoyu.springcloud.oauth.server.mapper;


import org.apache.ibatis.annotations.*;
import org.chenguoyu.springcloud.oauth.server.entity.SysUser;


import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "org.chenguoyu.springcloud.oauth.server.mapper.RoleMapper.findByUid"))
    })
    SysUser findByName(@Param("username") String username);

}
