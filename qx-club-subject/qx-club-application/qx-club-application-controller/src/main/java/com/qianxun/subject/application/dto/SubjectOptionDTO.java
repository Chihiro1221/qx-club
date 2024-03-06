package com.qianxun.subject.application.dto;

import lombok.Data;

/**
 * 题目选项DTO
 */
@Data
public class SubjectOptionDTO {
    /**
     * 是否正确
     */
    private long isCorrect;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 选项类型（1-A，2-B，3-C，4-D，5-E等）
     */
    private Integer optionType;
}