package com.qianxun.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目信息表(SubjectInfo)实体类
 *
 * @author makejava
 * @since 2024-03-05 19:24:31
 */
@Data
public class SubjectInfo implements Serializable {
    private static final long serialVersionUID = -59026415981642705L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目类型（1单选 2多选 3判断 4简答）
     */
    private Integer subjectType;
    /**
     * 题目难度
     */
    private Integer subjectDifficulty;
    /**
     * 出题人姓名
     */
    private String settleName;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
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

