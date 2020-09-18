package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.PrivilegeMapper;
import com.aliyun.code.typist.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
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
}
