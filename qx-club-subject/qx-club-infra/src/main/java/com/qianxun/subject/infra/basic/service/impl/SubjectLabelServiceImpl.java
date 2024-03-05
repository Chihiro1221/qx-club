package com.qianxun.subject.infra.basic.service.impl;

import com.qianxun.subject.infra.basic.entity.SubjectLabel;
import com.qianxun.subject.infra.basic.mapper.SubjectLabelDao;
import com.qianxun.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {
        int count = this.subjectLabelDao.insert(subjectLabel);
        return count;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
        int update = this.subjectLabelDao.update(subjectLabel);
        return update;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectLabel> queryBatchByIds(List<Long> labelIdList) {
        return this.subjectLabelDao.queryBatchByIds(labelIdList);
    }
}
