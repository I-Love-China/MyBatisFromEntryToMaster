package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.UserMapper;
import com.aliyun.code.typist.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SysUserMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            //
            // SysUser sysUser = sqlSession.selectOne("com.aliyun.code.typist.mapper.UserMapper.selectById", 1L);
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            System.out.println(sysUser);
        }
    }
}
