package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.RolePrivilegeMapper;
import com.aliyun.code.typist.model.SysRolePrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SysRolePrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectByRole() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<SysRolePrivilege> rolePrivilegeList = sqlSession.getMapper(RolePrivilegeMapper.class).selectByRole(1L);
            for(SysRolePrivilege rolePrivilege : rolePrivilegeList) {
                System.out.println(rolePrivilege);
            }
        }
    }
}
