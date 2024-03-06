package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.enums.SubjectTypeEnum;
import com.qianxun.subject.infra.basic.entity.SubjectBrief;
import com.qianxun.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目简答策略类
 */
@Component
public class SubjectBriefHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectTypeEnum getSubjectTypeEnum() {
        return SubjectTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectHandlerResultBO queryOptionBySubjectId(SubjectInfoBO subjectInfoBO) {
        SubjectHandlerResultBO handlerResultBO = new SubjectHandlerResultBO();
        SubjectBrief subjectBrief = subjectBriefService.queryBySubjectId(subjectInfoBO.getId());
        handlerResultBO.setSubjectAnswer(subjectBrief.getSubjectAnswer());
        return handlerResultBO;
    }
}
