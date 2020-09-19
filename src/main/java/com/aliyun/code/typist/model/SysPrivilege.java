package com.aliyun.code.typist.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysPrivilege implements Serializable {
    private static final long serialVersionUID = -5365572500788507037L;
    
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
}
