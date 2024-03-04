package com.qianxun.subject.application.convert;

import com.qianxun.subject.application.dto.SubjectCategoryDTO;
import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectCategory dto 转 bo
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    /**
     * subject dto bo to bo
     * @param subjectCategoryDTO
     * @return
     */
    SubjectCategoryBO convertDtoToCategoryBo(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBOToCategoryDTO(List<SubjectCategoryBO> subjectCategoryBO);
}
