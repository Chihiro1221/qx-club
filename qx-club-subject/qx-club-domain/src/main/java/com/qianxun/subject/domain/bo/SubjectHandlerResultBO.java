package com.qianxun.subject.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * 策略返回对象
 */
@Data
public class SubjectHandlerResultBO {
    private String subjectAnswer;
    private List<SubjectOptionBO> subjectOptionList;
}
