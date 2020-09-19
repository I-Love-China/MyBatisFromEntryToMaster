package com.aliyun.code.typist.mapper;

import com.aliyun.code.typist.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    SysUser selectById(Long id);

    int insert(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(SysUser sysUser);

    int deleteById(Long id);

    List<SysUser> selectByUserAndPwd(Map<String, String> params);

    List<SysUser> selectByUserAndPwd(@Param("userName") String userName,
                                     @Param("userPassword") String userPwd);

    List<SysUser> selectByUser(SysUser user);

    List<SysUser> selectByIdOrUserName(SysUser user);
}
