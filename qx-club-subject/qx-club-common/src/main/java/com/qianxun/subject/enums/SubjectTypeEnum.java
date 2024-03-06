package com.qianxun.subject.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 题目类型枚举类
 */
@Getter
public enum SubjectTypeEnum {
    RADIO(1, "单选"),
    MULTIPLE(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答");
    private Integer code;
    private String desc;

    SubjectTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据code获取对应enum类
     * @param code
     * @return
     */
    public static SubjectTypeEnum getSubjectTypeEnumByCode(Integer code) {
        SubjectTypeEnum[] values = values();
        for (SubjectTypeEnum subjectTypeEnum : values) {
            if (subjectTypeEnum.getCode().equals(code)) {
                return subjectTypeEnum;
            }
        }
        return null;
    }
}
