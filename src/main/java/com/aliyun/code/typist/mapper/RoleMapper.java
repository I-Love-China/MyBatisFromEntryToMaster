package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Long id);

    @Select("select * from sys_role")
    @ResultMap("roleMap")
    List<SysRole> selectAll();

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time"),
    })
    @Select("select * from sys_role where enabled = #{enabled}")
    List<SysRole> selectByEnabled(Integer enabled);
}
