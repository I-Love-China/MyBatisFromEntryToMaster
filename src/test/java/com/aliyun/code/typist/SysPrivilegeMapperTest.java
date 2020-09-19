package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.PrivilegeMapper;
import com.aliyun.code.typist.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SysPrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysPrivilege sysPrivilege = sqlSession.getMapper(PrivilegeMapper.class).selectById(1L);
            System.out.println(sysPrivilege);
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<SysPrivilege> privilegeList = sqlSession.getMapper(PrivilegeMapper.class).selectAll();
            for (SysPrivilege privilege : privilegeList) {
                System.out.println(privilege);
            }
        }
    }

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = getSqlSession()) {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            SysPrivilege privilege = new SysPrivilege();
            privilege.setPrivilegeName("测试 selectKey");
            privilege.setPrivilegeUrl("https://a.b.c");

            int rows = privilegeMapper.insert(privilege);
            Assert.assertEquals(rows, 1);
            Assert.assertNotNull(privilege.getId());

            sqlSession.rollback();
        }
    }
}
