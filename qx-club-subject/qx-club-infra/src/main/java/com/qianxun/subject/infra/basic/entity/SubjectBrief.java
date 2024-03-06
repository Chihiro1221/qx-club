package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 简答题目表(SubjectBrief)实体类
 *
 * @author makejava
 * @since 2024-03-05 19:24:57
 */
@Data
public class SubjectBrief implements Serializable {
    private static final long serialVersionUID = 336352766280418240L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 题目答案
     */
    private String subjectAnswer;
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

