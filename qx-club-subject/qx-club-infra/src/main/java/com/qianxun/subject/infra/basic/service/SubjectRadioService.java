package com.qianxun.subject.infra.basic.service;

import com.qianxun.subject.infra.basic.entity.SubjectRadio;

import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目表(SubjectRadio)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 19:25:54
 */
public interface SubjectRadioService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio insert(SubjectRadio subjectRadio);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 批量插入
     * @param subjectRadios
     */
    void insertBatch(LinkedList<SubjectRadio> subjectRadios);

    /**
     * 根据题目id获取选项
     * @param id
     * @return
     */
    List<SubjectRadio> queryBySubjectId(Long id);
}
