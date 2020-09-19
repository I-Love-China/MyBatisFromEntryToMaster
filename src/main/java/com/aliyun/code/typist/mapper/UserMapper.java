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

    List<SysUser> selectByWhere(SysUser user);

    List<SysUser> selectByTrim_Where(SysUser user);

    int updateByIdSelective(SysUser sysUser);

    int updateByTrim_Set(SysUser user);

    List<SysUser> selectByIdList(@Param("idList") List<Long> ids);

    List<SysUser> selectByIdArray(Long[] ids);

    int updateByMap(Map<String, Object> map);
}
