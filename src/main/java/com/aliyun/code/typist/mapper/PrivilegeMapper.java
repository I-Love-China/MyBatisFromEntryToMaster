package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysPrivilege;

import java.util.List;

public interface PrivilegeMapper {
    public SysPrivilege selectById(Long id);

    List<SysPrivilege> selectAll();
}
