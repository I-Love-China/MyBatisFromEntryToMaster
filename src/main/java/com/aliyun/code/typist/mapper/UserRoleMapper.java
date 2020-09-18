package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRole;

import java.util.List;

public interface UserRoleMapper {
    public List<SysRole> selectByUser(Long userId);
}
