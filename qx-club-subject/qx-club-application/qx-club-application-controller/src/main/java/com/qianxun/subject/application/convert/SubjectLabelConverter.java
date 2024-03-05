package com.qianxun.subject.application.convert;

import com.qianxun.subject.application.dto.SubjectLabelDTO;
import com.qianxun.subject.domain.bo.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectLabel dto 转 bo
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE = Mappers.getMapper(SubjectLabelConverter.class);

    /**
     * subject dto bo to bo
     * @param subjectLabelDTO
     * @return
     */
    SubjectLabelBO convertDtoToLabelBo(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBOToLabelDTO(List<SubjectLabelBO> subjectLabelBO);
}
