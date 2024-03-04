package com.qianxun.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qianxun.subject.domain.convert.SubjectCategoryConverter;
import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.domain.service.SubjectCategoryDomainService;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import com.qianxun.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类表(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-03-03 15:37:54
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    /**
     * 新增数据
     *
     * @param subjectCategoryBO 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.add.subjectCategoryBO: {}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        return subjectCategoryService.insert(subjectCategory);
    }

    /**
     * 查询分类
     *
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.query.subjectCategoryBO: {}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.query(subjectCategory);

        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE.convertCategoryListToBO(subjectCategoryList);
        return boList;
    }

    /**
     * 更新分类
     *
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.update.subjectCategoryBO: {}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);

        return count > 0;
    }

    /**
     * 根据id删除
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl.delete.subjectCategoryBO: {}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(LogicDeleteEnum.DELETED.getCode());

        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }
}
