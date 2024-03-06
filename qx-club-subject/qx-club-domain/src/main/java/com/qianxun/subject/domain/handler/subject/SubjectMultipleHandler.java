package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.domain.convert.SubjectJudgeConverter;
import com.qianxun.subject.domain.convert.SubjectMultipleConverter;
import com.qianxun.subject.domain.convert.SubjectTypeConverter;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.enums.SubjectTypeEnum;
import com.qianxun.subject.infra.basic.entity.SubjectJudge;
import com.qianxun.subject.infra.basic.entity.SubjectMultiple;
import com.qianxun.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目多选策略类
 */
@Component
public class SubjectMultipleHandler implements SubjectTypeHandler {

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectTypeEnum getSubjectTypeEnum() {
        return SubjectTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectOptionBO> optionListBO = subjectInfoBO.getSubjectOptionList();
        if (CollectionUtils.isEmpty(optionListBO)) {
            return;
        }
        LinkedList<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        optionListBO.forEach(optionBO -> {
            SubjectMultiple subjectMultiple = SubjectTypeConverter.INSTANCE.convertBoToMultiple(optionBO);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.insertBatch(subjectMultipleList);
    }

    @Override
    public SubjectHandlerResultBO queryOptionBySubjectId(SubjectInfoBO subjectInfoBO) {
        SubjectHandlerResultBO handlerResultBO = new SubjectHandlerResultBO();
        List<SubjectMultiple> subjectMultipleList = subjectMultipleService.queryBySubjectId(subjectInfoBO.getId());
        List<SubjectOptionBO> subjectOptionBOList = SubjectMultipleConverter.INSTANCE.convertMultipleListToOptionList(subjectMultipleList);
        handlerResultBO.setSubjectOptionList(subjectOptionBOList);
        return handlerResultBO;
    }
}
