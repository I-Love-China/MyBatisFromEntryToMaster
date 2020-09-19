package com.aliyun.code.typist;

import com.aliyun.code.typist.mapper.PrivilegeMapper;
import com.aliyun.code.typist.mapper.RoleMapper;
import com.aliyun.code.typist.mapper.UserMapper;
import com.aliyun.code.typist.model.SysPrivilege;
import com.aliyun.code.typist.model.SysRole;
import com.aliyun.code.typist.model.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest {
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test() {
        List<SysRole> roles = roleMapper.selectAll();
        Assert.assertNotNull(roles);
        Assert.assertTrue(!roles.isEmpty());

        List<SysPrivilege> privileges = privilegeMapper.selectAll();
        Assert.assertNotNull(privileges);
        Assert.assertTrue(!privileges.isEmpty());
    }
}
