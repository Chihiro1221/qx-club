package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectHandlerResultBO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.infra.basic.entity.SubjectInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * subjectInfo Bo转 Entity
 *
 * @author heart
 * @date 2024-03-03 19:31
 */
@Mapper
public interface SubjectInfoConverter {

    SubjectInfoConverter INSTANCE = Mappers.getMapper(SubjectInfoConverter.class);

    /**
     * subject Info bo to entity
     *
     * @param subjectInfoBO
     * @return
     */
    SubjectInfo convertBoToInfo(SubjectInfoBO subjectInfoBO);


    /**
     * subject bo to info entity
     *
     * @param subjectInfo
     * @return
     */
    SubjectInfoBO convertInfoToBO(SubjectInfo subjectInfo);

    /**
     * subject bo to info entity
     *
     * @param subjectInfo
     * @return
     */
    SubjectInfoBO convertInfoAndOptionToBO(SubjectInfo subjectInfo, SubjectHandlerResultBO subjectHandlerResultBO);

    /**
     * 将entity集合转换为bo集合
     *
     * @param subjectInfoBO
     * @return
     */
    List<SubjectInfoBO> convertInfoListToBO(List<SubjectInfo> subjectInfoBO);

}
