package com.aliyun.code.typist.model;

import com.aliyun.code.typist.type.Enabled;
import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long id;
    private String roleName;
    private Enabled enabled;
    private Long createBy;
    private Date createTime;
}
