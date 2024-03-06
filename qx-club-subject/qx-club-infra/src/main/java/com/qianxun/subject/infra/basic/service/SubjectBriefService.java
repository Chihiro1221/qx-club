package com.qianxun.subject.infra.basic.service;

import com.qianxun.subject.infra.basic.entity.SubjectBrief;

/**
 * 简答题目表(SubjectBrief)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 19:24:57
 */
public interface SubjectBriefService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectBrief queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief insert(SubjectBrief subjectBrief);

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    SubjectBrief update(SubjectBrief subjectBrief);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据题目id获取选项
     * @param subjectId
     * @return
     */
    SubjectBrief queryBySubjectId(Long subjectId);
}
