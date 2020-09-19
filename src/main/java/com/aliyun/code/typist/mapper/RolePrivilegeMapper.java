package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysRolePrivilege;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public interface RolePrivilegeMapper {
    @SelectProvider(type = RolePrivilegeProvider.class, method = "selectByRole")
    List<SysRolePrivilege> selectByRole(Long roleId);

    @SelectProvider(type = RolePrivilegeProvider.class, method = "selectAll")
    List<SysRolePrivilege> selectAll();

    // Provider 类的访问权限必须是 Public
    public static class RolePrivilegeProvider {
        // 方法必须返回 String 类型
        public String selectByRole(final Long roleId) {
            return "select * from sys_role_privilege where role_id = #{roleId}";
        }

        public String selectAll() {
            return new SQL() {
                {
                    SELECT("role_id, privilege_id");
                    FROM("sys_role_privilege");
                }
            }.toString();
        }
    }
}


