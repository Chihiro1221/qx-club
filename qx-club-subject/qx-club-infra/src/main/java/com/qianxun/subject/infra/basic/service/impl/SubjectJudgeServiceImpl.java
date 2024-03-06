package com.qianxun.subject.infra.basic.service.impl;

import com.qianxun.subject.infra.basic.entity.SubjectBrief;
import com.qianxun.subject.infra.basic.entity.SubjectJudge;
import com.qianxun.subject.infra.basic.mapper.SubjectJudgeDao;
import com.qianxun.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断题目表(SubjectJudge)表服务实现类
 *
 * @author makejava
 * @since 2024-03-05 19:25:17
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl implements SubjectJudgeService {
    @Resource
    private SubjectJudgeDao subjectJudgeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectJudge queryById(Long id) {
        return this.subjectJudgeDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge insert(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.insert(subjectJudge);
        return subjectJudge;
    }

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge update(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.update(subjectJudge);
        return this.queryById(subjectJudge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectJudgeDao.deleteById(id) > 0;
    }

    /**
     * 批量插入
     *
     * @param subjectJudgeList
     */
    @Override
    public void insertBatch(LinkedList<SubjectJudge> subjectJudgeList) {
        subjectJudgeDao.insertBatch(subjectJudgeList);
    }

    /**
     * 条件动态查询
     *
     * @param subjectId
     * @return
     */
    @Override
    public List<SubjectJudge> queryBySubjectId(Long subjectId) {
        return subjectJudgeDao.queryBySubjectId(subjectId);
    }
}
