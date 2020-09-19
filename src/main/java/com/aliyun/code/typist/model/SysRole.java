package com.aliyun.code.typist.model;

import com.aliyun.code.typist.type.Enabled;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable{
    private static final long serialVersionUID = -8437818190593786713L;// MyBatis 可读写的二级缓存使用 SerializedCache 存储缓存类，所以需要实现 Serializable 接口

    private Long id;
    private String roleName;
    private Enabled enabled;
    private Long createBy;
    private Date createTime;
}
