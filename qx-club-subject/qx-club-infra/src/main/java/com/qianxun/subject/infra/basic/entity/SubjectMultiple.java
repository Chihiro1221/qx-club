package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 多选题目表(SubjectMultiple)实体类
 *
 * @author makejava
 * @since 2024-03-05 19:25:38
 */
@Data
public class SubjectMultiple implements Serializable {
    private static final long serialVersionUID = 847640729430463530L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 选项类型
     */
    private String optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;
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

