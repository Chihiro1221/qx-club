package com.qianxun.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.convert.SubjectInfoConverter;
import com.qianxun.subject.domain.handler.subject.SubjectTypeHandler;
import com.qianxun.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.qianxun.subject.domain.service.SubjectInfoDomainService;
import com.qianxun.subject.entity.PageResult;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.infra.basic.entity.SubjectInfo;
import com.qianxun.subject.infra.basic.entity.SubjectLabel;
import com.qianxun.subject.infra.basic.entity.SubjectMapping;
import com.qianxun.subject.infra.basic.service.SubjectInfoService;
import com.qianxun.subject.infra.basic.service.SubjectLabelService;
import com.qianxun.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 21:48:42
 */
@Service
@Slf4j
public class SubjectInfoServiceDomainImpl implements SubjectInfoDomainService {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;
    @Resource
    private SubjectLabelService subjectLabelService;

    /**
     * 新增题目
     *
     * @param subjectInfoBO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.subjectInfoBO: {}", JSON.toJSONString(subjectInfoBO));
        }
        // 插入题目信息
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfo.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
        subjectInfoService.insert(subjectInfo);
        // 插入对应类型的题目选项
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoBO.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
        handler.add(subjectInfoBO);
        // 插入分类与标签关系
        List<Long> categoryIdList = subjectInfoBO.getCategoryIds();
        List<Long> labelIdList = subjectInfoBO.getLabelIds();
        // 排列组合插入分类标签题目关联表（多对多）
        LinkedList<SubjectMapping> subjectMappings = new LinkedList<>();
        for (Long categoryId : categoryIdList) {
            for (Long labelId : labelIdList) {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMapping.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
                subjectMappings.push(subjectMapping);
            }
        }
        // 批量插入
        subjectMappingService.insertBatch(subjectMappings);
    }

    /**
     * 分页查询题目
     *
     * @param subjectInfoBO
     * @return
     */
    @Override
    public PageResult<SubjectInfoBO> queryPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setCurrentPage(subjectInfoBO.getCurrentPage());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        // 暂时先做关联查询
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        int total = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        pageResult.setTotal(total);
        if (total == 0) {
            return pageResult;
        }
        // 分页查询数据
        int start = (subjectInfoBO.getCurrentPage() - 1) * subjectInfoBO.getPageSize();

        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.convertInfoListToBO(subjectInfoList);
        pageResult.setRecords(subjectInfoBOList);

        return pageResult;
    }

    /**
     * 根据id查询题目详情
     *
     * @param subjectInfoBO
     * @return
     */
    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        // 查询题目信息
        SubjectInfo subjectInfoResult = subjectInfoService.queryById(subjectInfoBO.getId());
        // 查询选项信息
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoResult.getSubjectType());
        SubjectHandlerResultBO handlerResultBO = handler.queryOptionBySubjectId(subjectInfoBO);
        // 封装响应对象
        SubjectInfoBO subjectInfoBOResult = SubjectInfoConverter.INSTANCE.convertInfoAndOptionToBO(subjectInfoResult, handlerResultBO);
        // 查询出题目关联标签信息
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelBySubjectId(subjectInfoResult.getId());
        if (!CollectionUtils.isEmpty(subjectMappingList)) {
            // 根据标签id查询标签名
            List<Long> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
            List<SubjectLabel> subjectLabelList = subjectLabelService.queryBatchByIds(labelIdList);
            // 设置标签名
            if (!CollectionUtils.isEmpty(subjectLabelList)) {
                subjectInfoBOResult.setLabelNames(subjectLabelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList()));
            }
        }
        return subjectInfoBOResult;
    }
}
