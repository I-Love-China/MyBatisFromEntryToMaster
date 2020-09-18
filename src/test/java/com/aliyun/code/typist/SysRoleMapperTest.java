package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.RoleMapper;
import com.aliyun.code.typist.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SysRoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysRole sysRole = sqlSession.getMapper(RoleMapper.class).selectById(1L);
            System.out.println(sysRole);
        }
    }
}
