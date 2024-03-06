package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目、分类、 标签关联表(SubjectMapping)实体类
 *
 * @author makejava
 * @since 2024-03-05 18:27:46
 */
@Data
public class SubjectMapping implements Serializable {
    private static final long serialVersionUID = 501475201533035849L;
/**
     * id主键
     */
    private Long id;
/**
     * 题目id
     */
    private Long subjectId;
/**
     * 分类id
     */
    private Long categoryId;
/**
     * 标签id
     */
    private Long labelId;
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

