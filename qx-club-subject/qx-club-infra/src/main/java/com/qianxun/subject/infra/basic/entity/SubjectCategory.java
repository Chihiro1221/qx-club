package com.qianxun.subject.infra.basic.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类表(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-03-03 15:37:53
 */
@Data
public class SubjectCategory implements Serializable {
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

