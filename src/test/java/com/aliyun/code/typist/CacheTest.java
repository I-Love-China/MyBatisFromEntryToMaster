package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.UserMapper;
import com.aliyun.code.typist.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

public class CacheTest extends BaseMapperTest {
    @Test
    public void testL1Cache() {
        // 一级缓存默认启用，并且不受控制
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user1 = userMapper.selectById(1L);
            user1.setUserEmail("xxx");

            SysUser user2 = userMapper.selectById(1L);

            Assert.assertEquals("xxx", user2.getUserEmail());
            Assert.assertTrue(user1 == user2);
        }

        System.out.println("开启新的 SqlSession");

        // 一级缓存只存在于 SqlSession 的生命周期中
        // 任何的 INSERT、UPDATE、DELETE 操作都会清空一级缓存
        // flushCache=true 的 SELECT 语句也会清空一级缓存
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user1 = userMapper.selectById(1L);
            user1.setUserEmail("xxx");

            SysUser user2 = userMapper.selectById(1L);

            Assert.assertEquals("xxx", user2.getUserEmail());
            Assert.assertTrue(user1 == user2);

            // 删除操作
            userMapper.deleteById(2L);

            SysUser user3 = userMapper.selectById(1L);
            Assert.assertFalse(user1 == user3);
            Assert.assertFalse(user2 == user3);

            sqlSession.rollback();
        }
    }
}
