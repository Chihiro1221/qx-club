package com.qianxun.subject.domain.service;

import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.entity.PageResult;

import java.util.List;

/**
 * 题目(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
public interface SubjectInfoDomainService {
    /**
     * 添加题目
     * @param subjectInfoBO
     * @return
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> queryPage(SubjectInfoBO subjectInfoBO);

    /**
     * 根据id查询题目详情
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
