package com.qianxun.subject.domain.service;

import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @author heart@date 2024-03-03 19:25
 */
public interface SubjectCategoryDomainService {
    /**
     * 新增数据
     *
     * @param subjectCategoryBO 实例对象
     * @return 实例对象
     */
    SubjectCategory add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 根据id删除
     * @param subjectCategoryBO
     * @return
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
