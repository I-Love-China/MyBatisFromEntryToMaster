package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.RoleMapper;
import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class SysRoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysRole sysRole = sqlSession.getMapper(RoleMapper.class).selectById(1L);
            System.out.println(sysRole);
        }
    }

    @Test
    public void testSelectAll() {
        try(SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roles = roleMapper.selectAll();

            Assert.assertNotNull(roles);
            Assert.assertTrue(!roles.isEmpty());
        }
    }

    @Test
    public void testSelectByEnabled() {
        try(SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roles = roleMapper.selectByEnabled(1);

            Assert.assertNotNull(roles);
            Assert.assertTrue(!roles.isEmpty());
        }
    }

    @Test
    public void testSelectByCreateBy() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<SysRole> roles = roleMapper.selectByCreateBy(1L);

            Assert.assertNotNull(roles);
            Assert.assertTrue(!roles.isEmpty());
        }
    }

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role = new SysRole();
            role.setRoleName("测试插入");
            role.setEnabled(0);
            role.setCreateBy(1L);
            role.setCreateTime(new Date());

            int rows = roleMapper.insert(role);
            Assert.assertEquals(rows, 1);

            sqlSession.rollback();
        }
    }

    @Test
    public void testInsertAndWriteBackId() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role = new SysRole();
            role.setRoleName("测试插入");
            role.setEnabled(0);
            role.setCreateBy(1L);
            role.setCreateTime(new Date());

            int rows = roleMapper.insertAndWriteBackId_JDBC(role);
            Assert.assertEquals(rows, 1);
            Assert.assertNotNull(role.getId());

            SysRole role_2 = new SysRole();
            role_2.setRoleName("测试插入_2");
            role_2.setEnabled(1);
            role_2.setCreateBy(1001L);
            role_2.setCreateTime(new Date());

            int rows_2 = roleMapper.insertAndWriteBackId_SELECT_KEY(role_2);
            Assert.assertEquals(rows_2, 1);
            Assert.assertNotNull(role_2.getId());

            sqlSession.rollback();
        }
    }

    @Test
    public void testDelete() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            int rows = roleMapper.deleteById(1L);
            Assert.assertEquals(rows, 1);

            sqlSession.rollback();
        }
    }
}
