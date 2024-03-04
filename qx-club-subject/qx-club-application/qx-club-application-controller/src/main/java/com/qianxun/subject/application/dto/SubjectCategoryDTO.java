package com.qianxun.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类表(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-03-03 15:37:53
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = 628173704657721317L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 分类名
     */
    private String categoryName;
    /**
     * 父分类id
     */
    private Long parentId;
    /**
     * 分类图标地址
     */
    private String categoryIcon;
    /**
     * 分类类型
     */
    private Integer categoryType;
}

