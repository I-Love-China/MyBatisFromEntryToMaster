package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Select("select * from sys_role where id = #{id}")
    SysRole selectById(Long id);

    @Select("select * from sys_role")
    @ResultMap("roleMap")
    List<SysRole> selectAll();

    @Results(id = "@roleMap",
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "roleName", column = "role_name"),
                    @Result(property = "enabled", column = "enabled"),
                    @Result(property = "createBy", column = "create_by"),
                    @Result(property = "createTime", column = "create_time"),
            })
    @Select("select * from sys_role where enabled = #{enabled}")
    List<SysRole> selectByEnabled(Integer enabled);

    @Select("select * from sys_role where create_by = #{creatorId}")
    @ResultMap("@roleMap")
    List<SysRole> selectByCreateBy(Long creatorId);

    @Insert({
            "insert into sys_role",
            "(id, role_name, enabled, create_by, create_time) values",
            "(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime})"
    })
    int insert(SysRole role);

    @Insert({
            "insert into sys_role",
            "(role_name, enabled, create_by, create_time) values",
            "(#{roleName}, #{enabled}, #{createBy}, #{createTime})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertAndWriteBackId_JDBC(SysRole role);

    @Insert({
            "insert into sys_role",
            "(role_name, enabled, create_by, create_time) values",
            "(#{roleName}, #{enabled}, #{createBy}, #{createTime})"
    })
    @SelectKey(
            statement = "select last_insert_id()",
            keyProperty = "id",
            resultType = long.class,
            before = false
    )
    int insertAndWriteBackId_SELECT_KEY(SysRole role);

    @Delete("delete from sys_role where id = #{id}")
    int deleteById(Long id);
}
