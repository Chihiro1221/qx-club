package com.qianxun.subject.enums;

import lombok.Getter;

/**
 * 结果响应类型枚举类
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "请求成功！"),
    FAIL(500, "服务器异常");
    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
