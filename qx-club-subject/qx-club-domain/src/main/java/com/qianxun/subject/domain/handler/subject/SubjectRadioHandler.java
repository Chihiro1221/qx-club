package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.domain.convert.SubjectRadioConverter;
import com.qianxun.subject.domain.convert.SubjectTypeConverter;
import com.qianxun.subject.enums.LogicDeleteEnum;
import com.qianxun.subject.enums.SubjectTypeEnum;
import com.qianxun.subject.infra.basic.entity.SubjectRadio;
import com.qianxun.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目单选策略类
 */
@Component
public class SubjectRadioHandler implements SubjectTypeHandler {
    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectTypeEnum getSubjectTypeEnum() {
        return SubjectTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectOptionBO> optionListBO = subjectInfoBO.getSubjectOptionList();
        if (CollectionUtils.isEmpty(optionListBO)) {
            return;
        }
        LinkedList<SubjectRadio> subjectRadios = new LinkedList<>();
        optionListBO.forEach(optionBO -> {
            SubjectRadio subjectRadio = SubjectTypeConverter.INSTANCE.convertBoToRadio(optionBO);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(LogicDeleteEnum.UN_DELETED.getCode());
            subjectRadios.add(subjectRadio);
        });
        subjectRadioService.insertBatch(subjectRadios);
    }

    @Override
    public SubjectHandlerResultBO queryOptionBySubjectId(SubjectInfoBO subjectInfoBO) {
        SubjectHandlerResultBO handlerResultBO = new SubjectHandlerResultBO();
        List<SubjectRadio> subjectRadioList  = subjectRadioService.queryBySubjectId(subjectInfoBO.getId());
        List<SubjectOptionBO> subjectOptionBOList = SubjectRadioConverter.INSTANCE.convertMultipleListToOptionList(subjectRadioList);
        handlerResultBO.setSubjectOptionList(subjectOptionBOList);
        return handlerResultBO;
    }
}
