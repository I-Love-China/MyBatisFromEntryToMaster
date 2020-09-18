package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Long id);
}
