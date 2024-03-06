package com.qianxun.subject.domain.convert;

import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.bo.SubjectOptionBO;
import com.qianxun.subject.infra.basic.entity.SubjectInfo;
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
public interface SubjectTypeConverter {

    SubjectTypeConverter INSTANCE = Mappers.getMapper(SubjectTypeConverter.class);

    /**
     * 选项DTO转换为单选实体
     *
     * @param subjectOptionBO
     * @return
     */
    SubjectRadio convertBoToRadio(SubjectOptionBO subjectOptionBO);

    /**
     * 选项DTO转换为多选实体
     *
     * @param subjectOptionBO
     * @return
     */
    SubjectMultiple convertBoToMultiple(SubjectOptionBO subjectOptionBO);

    /**
     * 选项DTO转换为判断实体
     *
     * @param subjectOptionBO
     * @return
     */
    SubjectJudge convertBoToJudge(SubjectOptionBO subjectOptionBO);

    /**
     * 将entity集合转换为bo集合
     *
     * @param subjectInfoBO
     * @return
     */
    List<SubjectInfoBO> convertInfoListToBO(List<SubjectInfo> subjectInfoBO);
}
