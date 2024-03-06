package com.qianxun.subject.application.convert;

import com.qianxun.subject.application.dto.SubjectInfoDTO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectInfo dto 转 bo
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    /**
     * subject dto bo to bo
     *
     * @param subjectInfoDTO
     * @return
     */
    SubjectInfoBO convertDtoToInfoBo(SubjectInfoDTO subjectInfoDTO);

    List<SubjectInfoDTO> convertBOListToInfoDTOList(List<SubjectInfoBO> subjectInfoBO);

    SubjectInfoDTO convertBOToInfoDTO(SubjectInfoBO subjectInfoBO);
}
