package com.aliyun.code.typist.model;

import lombok.Data;

import java.util.Date;

// MyBatis 默认支持下划线转驼峰的字段命名
// 字段不要使用基本类型
@Data
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo; // 简介
    private byte[] headImg;
    private Date createTime;
}
