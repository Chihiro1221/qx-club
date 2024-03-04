package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectCategory Bo转 Entity
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    /**
     * subject category bo to entity
     * @param subjectCategoryBO
     * @return
     */
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 将entity集合转换为bo集合
     * @param subjectCategoryBO
     * @return
     */
    List<SubjectCategoryBO> convertCategoryListToBO(List<SubjectCategory> subjectCategoryBO);
}
