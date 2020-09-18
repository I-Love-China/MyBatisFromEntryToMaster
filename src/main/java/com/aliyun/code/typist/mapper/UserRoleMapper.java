package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysUserRole;

import java.util.List;

public interface UserRoleMapper {
    public List<SysUserRole> selectByUser(Long userId);
}
