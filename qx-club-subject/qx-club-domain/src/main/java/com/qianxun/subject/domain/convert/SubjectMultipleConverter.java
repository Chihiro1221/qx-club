package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.infra.basic.entity.SubjectJudge;
import com.qianxun.subject.infra.basic.entity.SubjectMultiple;
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
public interface SubjectMultipleConverter {

    SubjectMultipleConverter INSTANCE = Mappers.getMapper(SubjectMultipleConverter.class);

    List<SubjectOptionBO> convertMultipleListToOptionList(List<SubjectMultiple> subjectMultipleList);
}
