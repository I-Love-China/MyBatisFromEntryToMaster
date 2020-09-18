package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRolePrivilege;

import java.util.List;

public interface RolePrivilegeMapper {
    public List<SysRolePrivilege> selectByRole(Long roleId);
}
