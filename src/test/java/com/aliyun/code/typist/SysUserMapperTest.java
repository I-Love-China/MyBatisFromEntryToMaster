package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.UserMapper;
import com.aliyun.code.typist.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testUpdateById() {
        try(SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);

            user.setUserInfo("测试 update");
            int rows = userMapper.updateById(user);

            Assert.assertEquals(rows, 1);

            sqlSession.rollback();
        }
    }

    @Test
    public void testDeleteById() {
        try(SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);

            int rows = userMapper.deleteById(user);
            Assert.assertEquals(rows, 1);

            int rows_2 = userMapper.deleteById(1001L);
            Assert.assertEquals(rows_2, 1);

            sqlSession.rollback();
        }
    }

    @Test
    public void testSelectByUserAndPwd() {
        try(SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, String> params = new HashMap<>();
            params.put("userName", "admin");
            params.put("userPassword", "123456");

            List<SysUser> userList = userMapper.selectByUserAndPwd(params);
            Assert.assertNotNull(userList);
            Assert.assertTrue(!userList.isEmpty());

            List<SysUser> userList_2 = userMapper.selectByUserAndPwd("test", "123456");
            Assert.assertNotNull(userList_2);
            Assert.assertTrue(!userList_2.isEmpty());
        }
    }
}
