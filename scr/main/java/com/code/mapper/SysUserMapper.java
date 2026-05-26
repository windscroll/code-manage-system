package com.code.mapper;

import com.code.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    SysUser login(@Param("username") String username,@Param("password") String password);
}