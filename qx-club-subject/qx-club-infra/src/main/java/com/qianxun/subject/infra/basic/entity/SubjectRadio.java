package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 单选题目表(SubjectRadio)实体类
 *
 * @author makejava
 * @since 2024-03-05 19:25:54
 */
@Data
public class SubjectRadio implements Serializable {
    private static final long serialVersionUID = 819295758370944206L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 题目id
     */
    private Long subjectId;
    /**
     * 选项类型（1-A，2-B，3-C，4-D，5-E等）
     */
    private Integer optionType;
    /**
     * 选项内容
     */
    private String optionContent;
    /**
     * 该选项是否正确
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

