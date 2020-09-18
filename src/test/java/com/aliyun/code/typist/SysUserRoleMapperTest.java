package com.aliyun.code.typist;


import com.aliyun.code.typist.mapper.UserRoleMapper;
import com.aliyun.code.typist.model.SysRole;
import com.aliyun.code.typist.model.SysUserRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SysUserRoleMapperTest extends BaseMapperTest {
    @Test
    public void testSelectByUser() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<SysUserRole> roleList = sqlSession.getMapper(UserRoleMapper.class).selectByUser(1L);
            for(SysUserRole userRole: roleList) {
                System.out.println(userRole);
            }
        }
    }
}
