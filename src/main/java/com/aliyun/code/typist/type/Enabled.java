package com.aliyun.code.typist.type;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum Enabled {
    ENABLED(1, "未禁用"),
    DISABLED(0, "已禁用");

    public static Enabled find(Integer code) {

        return CODE_EnumMap.get(code);
    }


    private @Getter final int code;
    private @Getter final String desc;

    private Enabled(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Integer, Enabled> CODE_EnumMap = new HashMap<>();

    static {
        for (Enabled e : values()) {
            CODE_EnumMap.put(e.code, e);
        }
    }
}
