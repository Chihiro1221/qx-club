package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.domain.convert.SubjectJudgeConverter;
import com.qianxun.subject.domain.convert.SubjectTypeConverter;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.enums.SubjectTypeEnum;
import com.qianxun.subject.infra.basic.entity.SubjectJudge;
import com.qianxun.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目判断策略类
 */
@Component
public class SubjectJudgeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectJudgeService subjectJudgeService;

    @Override
    public SubjectTypeEnum getSubjectTypeEnum() {
        return SubjectTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectOptionBO> optionListBO = subjectInfoBO.getSubjectOptionList();
        if (CollectionUtils.isEmpty(optionListBO)) {
            return;
        }
        LinkedList<SubjectJudge> subjectJudgeList = new LinkedList<>();
        optionListBO.forEach(optionBO -> {
            SubjectJudge subjectJudge = SubjectTypeConverter.INSTANCE.convertBoToJudge(optionBO);
            subjectJudge.setSubjectId(subjectInfoBO.getId());
            subjectJudge.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
            subjectJudgeList.add(subjectJudge);
        });
        subjectJudgeService.insertBatch(subjectJudgeList);
    }

    @Override
    public SubjectHandlerResultBO queryOptionBySubjectId(SubjectInfoBO subjectInfoBO) {
        SubjectHandlerResultBO handlerResultBO = new SubjectHandlerResultBO();
        List<SubjectJudge> subjectJudgeList = subjectJudgeService.queryBySubjectId(subjectInfoBO.getId());
        List<SubjectOptionBO> subjectOptionBOList = SubjectJudgeConverter.INSTANCE.convertJudgeListToOptionList(subjectJudgeList);
        handlerResultBO.setSubjectOptionList(subjectOptionBOList);
        return handlerResultBO;
    }
}
