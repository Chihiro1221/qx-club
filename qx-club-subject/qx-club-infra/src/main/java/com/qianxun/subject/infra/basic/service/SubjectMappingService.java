package com.qianxun.subject.infra.basic.service;

import com.qianxun.subject.infra.basic.entity.SubjectMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目、分类、 标签关联表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 18:27:46
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMapping queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping insert(SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据分类id查询题目标签
     * @param categoryId
     * @return
     */
    List<SubjectMapping> queryBatchByCategoryId(Long categoryId);

    /**
     * 批量插入
     * @param subjectMappings
     */
    void insertBatch(LinkedList<SubjectMapping> subjectMappings);

    /**
     * 根据题目id查询标签信息
     * @param id
     * @return
     */
    List<SubjectMapping> queryLabelBySubjectId(Long id);
}
