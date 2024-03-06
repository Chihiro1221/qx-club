package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.enums.SubjectTypeEnum;

/**
 * 题目类型工厂类
 */
public interface SubjectTypeHandler {
    /**
     * 获取当前类的题目类型枚举
     * @return
     */
    SubjectTypeEnum getSubjectTypeEnum();

    void add(SubjectInfoBO subjectInfoBO);

    SubjectHandlerResultBO queryOptionBySubjectId(SubjectInfoBO subjectInfoBO);
}

