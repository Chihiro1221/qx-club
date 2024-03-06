package com.qianxun.subject.infra.basic.service.impl;

import com.qianxun.subject.infra.basic.entity.SubjectMapping;
import com.qianxun.subject.infra.basic.mapper.SubjectMappingDao;
import com.qianxun.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目、分类、 标签关联表(SubjectMapping)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 18:27:46
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl implements SubjectMappingService {
    @Resource
    private SubjectMappingDao subjectMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectMapping queryById(Long id) {
        return this.subjectMappingDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping insert(SubjectMapping subjectMapping) {
        this.subjectMappingDao.insert(subjectMapping);
        return subjectMapping;
    }

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMapping update(SubjectMapping subjectMapping) {
        this.subjectMappingDao.update(subjectMapping);
        return this.queryById(subjectMapping.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectMappingDao.deleteById(id) > 0;
    }

    /**
     * 根据分类id查询题目标签
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<SubjectMapping> queryBatchByCategoryId(Long categoryId) {
        return subjectMappingDao.queryBatch(categoryId);
    }

    /**
     * 批量插入
     *
     * @param subjectMappings
     */
    @Override
    public void insertBatch(LinkedList<SubjectMapping> subjectMappings) {
        subjectMappingDao.insertBatch(subjectMappings);
    }

    /**
     * 根据题目id查询标签信息
     * @param id
     * @return
     */
    @Override
    public List<SubjectMapping> queryLabelBySubjectId(Long id) {
        return subjectMappingDao.queryLabelBySubjectId(id);
    }
}
