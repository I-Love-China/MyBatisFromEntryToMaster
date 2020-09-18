package com.aliyun.code.typist;

import com.aliyun.code.typist.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SysPrivilegeMapperTest extends BaseMapperTest {
    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            SysPrivilege sysPrivilege = sqlSession.selectOne("com.aliyun.code.typist.mapper.PrivilegeMapper.selectById", 1L);
            System.out.println(sysPrivilege);
        }
    }
}
