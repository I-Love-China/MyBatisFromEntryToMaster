package com.aliyun.code.typist.model;

import lombok.Data;

/**
 * 角色权限关联表
 */
@Data
public class SysRolePrivilege {
    private Long roleId;
    private Long privilegeId;
}
