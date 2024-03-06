package com.qianxun.subject.infra.basic.service;

import com.qianxun.subject.infra.basic.entity.SubjectMultiple;

import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目表(SubjectMultiple)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 19:25:39
 */
public interface SubjectMultipleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMultiple queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple insert(SubjectMultiple subjectMultiple);

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    SubjectMultiple update(SubjectMultiple subjectMultiple);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入
     * @param subjectMultipleList
     */
    void insertBatch(LinkedList<SubjectMultiple> subjectMultipleList);

    /**
     * 根据题目id获取选项
     * @param id
     * @return
     */
    List<SubjectMultiple> queryBySubjectId(Long id);
}
