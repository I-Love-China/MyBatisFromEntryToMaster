package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.RolePrivilegeMapper;
import com.aliyun.code.typist.model.SysRolePrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class SysRolePrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectByRole() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<SysRolePrivilege> rolePrivilegeList = sqlSession.getMapper(RolePrivilegeMapper.class).selectByRole(1L);

            print(rolePrivilegeList);
        }
    }

    @Test
    public void testSelectAll() {
        try(SqlSession sqlSession = getSqlSession()) {
            List<SysRolePrivilege> rolePrivileges = sqlSession.getMapper(RolePrivilegeMapper.class).selectAll();

            Assert.assertNotNull(rolePrivileges);
            Assert.assertTrue(!rolePrivileges.isEmpty());

            print(rolePrivileges);
        }
    }

    private void print(Collection<SysRolePrivilege> rolePrivileges) {
        if (null == rolePrivileges || rolePrivileges.isEmpty()) {
            return;
        }

        for (SysRolePrivilege rolePrivilege : rolePrivileges) {
            System.out.println(rolePrivilege);
        }
    }
}
