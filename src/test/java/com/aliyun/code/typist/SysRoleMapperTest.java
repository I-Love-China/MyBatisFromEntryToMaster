package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.RoleMapper;
import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

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
}
