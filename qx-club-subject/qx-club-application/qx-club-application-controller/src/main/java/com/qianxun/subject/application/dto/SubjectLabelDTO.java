package com.qianxun.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = -28630583391212796L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 标签名
     */
    private String labelName;
    /**
     * 所属分类id
     */
    private Long categoryId;
    /**
     * 排序
     */
    private Integer sortNum;
}

