package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.UserMapper;
import com.aliyun.code.typist.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setUserName("ZhangSan");
            user.setUserInfo("测试插入新用户");
            user.setUserEmail("123@qq.com");
            user.setCreateTime(new Date());

            int rows = userMapper.insert(user);
            Assert.assertEquals(1, rows);
            Assert.assertNotNull(user.getId());

            sqlSession.rollback();
        }
    }
}
