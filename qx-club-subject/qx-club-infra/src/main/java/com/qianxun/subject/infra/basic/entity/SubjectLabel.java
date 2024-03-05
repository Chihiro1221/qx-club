package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
@Data
public class SubjectLabel implements Serializable {
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
    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 更新时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private Long updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 逻辑删除
     */
    private Integer isDeleted;
}

