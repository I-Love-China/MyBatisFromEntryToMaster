package com.aliyun.code.typist.model;

import lombok.Data;

/**
 * 用户角色关联表
 */
@Data
public class SysUserRole {
    private Long userId;
    private Long roleId;
}
