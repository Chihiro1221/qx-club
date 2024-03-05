package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectLabelBO;
import com.qianxun.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectLabel Bo转 Entity
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    /**
     * subject Label bo to entity
     * @param subjectLabelBO
     * @return
     */
    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    /**
     * 将entity集合转换为bo集合
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> convertLabelListToBO(List<SubjectLabel> subjectLabelBO);
}
