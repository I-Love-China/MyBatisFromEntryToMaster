package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysUser;

public interface UserMapper {
    SysUser selectById(Long id);
}
