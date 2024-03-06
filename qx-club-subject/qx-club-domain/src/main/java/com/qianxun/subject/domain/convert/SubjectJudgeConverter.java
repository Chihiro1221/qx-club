package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.infra.basic.entity.SubjectJudge;
import com.qianxun.subject.infra.basic.entity.SubjectMultiple;
import com.qianxun.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subject type Bo转 type Entity
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectJudgeConverter {

    SubjectJudgeConverter INSTANCE = Mappers.getMapper(SubjectJudgeConverter.class);

    /**
     * 将entity集合转换为bo集合
     *
     * @param subjectJudgeList
     * @return
     */
    List<SubjectOptionBO> convertJudgeListToOptionList(List<SubjectJudge> subjectJudgeList);

}
