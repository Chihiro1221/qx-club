package com.qianxun.subject.enums;

import lombok.Getter;

/**
 * 逻辑删除枚举类
 */
@Getter
public enum LogicDeleteEnum {
    DELETED(1, "已删除"),
    UN_DELETED(0, "未删除");
    private Integer code;
    private String desc;

    LogicDeleteEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
