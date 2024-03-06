package com.qianxun.subject.application.dto;

import com.qianxun.subject.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)DTO
 *
 * @author makejava
 * @since 2024-03-05 19:24:31
 */
@Data
public class SubjectInfoDTO extends PageInfo implements Serializable {
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
     * 题目标签集合
     */
    private List<String> labelNames;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目选项
     */
    private List<SubjectOptionDTO> subjectOptionList;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 所属分类集合
     */
    private List<Long> categoryIds;

    /**
     * 所属标签集合
     */
    private List<Long> labelIds;

    /**
     * 所属分类
     */
    private Long categoryId;

    /**
     * 所属标签
     */
    private Long labelId;
}