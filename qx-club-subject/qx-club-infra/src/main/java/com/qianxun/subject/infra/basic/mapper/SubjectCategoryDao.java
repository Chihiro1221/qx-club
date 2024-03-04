package com.qianxun.subject.infra.basic.mapper;

import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目分类表(SubjectCategory)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-03 15:37:53
 */
public interface SubjectCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键1
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 影响行数
     */
    int insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 影响行数
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 查询分类
     * @param subjectCategory
     * @return
     */
    List<SubjectCategory> queryCategoryList(SubjectCategory subjectCategory);
}

