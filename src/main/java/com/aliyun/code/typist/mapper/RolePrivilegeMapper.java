package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysPrivilege;

import java.util.List;

public interface RolePrivilegeMapper {
    public List<SysPrivilege> selectByRole(Long roleId);
}
