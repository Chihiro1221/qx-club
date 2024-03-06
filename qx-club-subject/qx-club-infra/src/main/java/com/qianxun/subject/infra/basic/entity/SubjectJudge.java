package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 判断题目表(SubjectJudge)实体类
 *
 * @author makejava
 * @since 2024-03-05 19:25:16
 */
@Data
public class SubjectJudge implements Serializable {
    private static final long serialVersionUID = -72624947582928531L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
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

