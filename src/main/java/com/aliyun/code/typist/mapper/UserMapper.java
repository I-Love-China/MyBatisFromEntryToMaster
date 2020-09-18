package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysUser;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    SysUser selectById(Long id);

    int insert(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(SysUser sysUser);

    int deleteById(Long id);

    List<SysUser> selectByUserAndPwd(Map<String, String> params);
}
