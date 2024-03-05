package com.qianxun.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qianxun.subject.domain.bo.SubjectLabelBO;
import com.qianxun.subject.domain.convert.SubjectCategoryConverter;
import com.qianxun.subject.domain.convert.SubjectLabelConverter;
import com.qianxun.subject.domain.service.SubjectLabelDomainService;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import com.qianxun.subject.infra.basic.entity.SubjectLabel;
import com.qianxun.subject.infra.basic.entity.SubjectMapping;
import com.qianxun.subject.infra.basic.mapper.SubjectLabelDao;
import com.qianxun.subject.infra.basic.service.SubjectLabelService;
import com.qianxun.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
@Service
@Slf4j
public class SubjectLabelServiceDomainImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    /**
     * 新增标签
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.add.subjectLabelBO: {}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }

    /**
     * 更新标签
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.update.subjectLabelBO: {}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 删除标签
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.delete.subjectLabelBO: {}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(LogicDeleteEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    /**
     * 根据分类id查询标签
     *
     * @param subjectLabelBO
     * @return
     */
    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelDomainServiceImpl.query.subjectLabelBO: {}", JSON.toJSONString(subjectLabelBO));
        }
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryBatchByCategoryId(subjectLabelBO.getCategoryId());
        if (CollectionUtils.isEmpty(subjectMappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        // 根据关联表中的标签id查询标签信息
        List<SubjectLabel> labelList = subjectLabelService.queryBatchByIds(labelIdList);
        List<SubjectLabelBO> subjectLabelBOS = SubjectLabelConverter.INSTANCE.convertLabelListToBO(labelList);
        return subjectLabelBOS;
    }
}
