package com.qianxun.subject.domain.handler.subject;

import com.qianxun.subject.enums.SubjectTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目类型策略工厂
 */
@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
    private List<SubjectTypeHandler> subjectTypeHandlerList;

    Map<SubjectTypeEnum, SubjectTypeHandler> subjectTypeHandlerMap = new HashMap<>();

    /**
     * 获取handler
     *
     * @param subjectType
     * @return
     */
    public SubjectTypeHandler getHandler(Integer subjectType) {
        SubjectTypeEnum subjectEnum = SubjectTypeEnum.getSubjectTypeEnumByCode(subjectType);
        return subjectTypeHandlerMap.get(subjectEnum);
    }


    /**
     * 当bean对象初始化之后执行
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        subjectTypeHandlerList.forEach(subjectTypeHandler ->
                subjectTypeHandlerMap.put(subjectTypeHandler.getSubjectTypeEnum(), subjectTypeHandler));
    }
}
