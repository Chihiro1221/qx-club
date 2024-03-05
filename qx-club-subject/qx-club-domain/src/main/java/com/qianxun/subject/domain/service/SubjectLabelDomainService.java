package com.qianxun.subject.domain.service;

import com.qianxun.subject.domain.bo.SubjectLabelBO;
import com.qianxun.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
public interface SubjectLabelDomainService {
    /**
     * 添加标签
     * @param subjectLabelBO
     * @return
     */
    Boolean add(SubjectLabelBO subjectLabelBO);

    /**
     * 更新标签
     * @param subjectLabelBO
     * @return
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO
     * @return
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类id查询标签
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
