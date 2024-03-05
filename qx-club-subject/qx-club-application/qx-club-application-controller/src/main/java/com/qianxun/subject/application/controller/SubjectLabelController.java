package com.qianxun.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.qianxun.subject.application.convert.SubjectCategoryConverter;
import com.qianxun.subject.application.convert.SubjectLabelConverter;
import com.qianxun.subject.application.dto.SubjectCategoryDTO;
import com.qianxun.subject.application.dto.SubjectLabelDTO;
import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.domain.bo.SubjectLabelBO;
import com.qianxun.subject.domain.service.SubjectLabelDomainService;
import com.qianxun.subject.entity.Result;
import com.qianxun.subject.infra.basic.entity.SubjectLabel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签controller
 *
 * @author haonan
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    /**
     * 新增标签
     *
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/add")
    public Result addSubjectLabel(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.add.subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectLabelDTO.getLabelName()), "标签名不能为空！");
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(), "标签分类不能为空！");
            // dto转bo
            SubjectLabelBO subjectLabelBO = SubjectLabelConverter.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(subjectLabelBO);
            Preconditions.checkArgument(result);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("addSubjectLabel出现异常：{}", e);
            return Result.fail("添加失败！");
        }
    }


    /**
     * 更新标签
     *
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.update.subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "id不能为空");
            // dto转bo
            SubjectLabelBO subjectLabelBO = SubjectLabelConverter.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.query.subjectLabelDTO出错: {}", e.getMessage(), e);
            return Result.fail("更新失败！");
        }
    }

    /**
     * 删除标签
     *
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.delete.subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectLabelDTO.getId(), "id不能为空");
            // dto转bo
            SubjectLabelBO subjectLabelBO = SubjectLabelConverter.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectLabelController.delete.subjectLabelDTO出错: {}", e.getMessage(), e);
            return Result.fail("删除失败！");
        }
    }

    /**
     * 根据分类id查询标签
     *
     * @param subjectLabelDTO
     * @return
     */
    @PostMapping("/queryLabel")
    public Result<List<SubjectLabelDTO>> queryLabelByType(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectLabelController.query.subjectLabelDTO: {}", JSON.toJSONString(subjectLabelDTO));
            }
            // dto转bo
            SubjectLabelBO subjectLabelBO = SubjectLabelConverter.INSTANCE.convertDtoToLabelBo(subjectLabelDTO);
            List<SubjectLabelBO> LabelList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            // bo转dto
            List<SubjectLabelDTO> boList = SubjectLabelConverter.INSTANCE.convertBOToLabelDTO(LabelList);
            Preconditions.checkNotNull(boList);
            return Result.ok(boList);
        } catch (Exception e) {
            log.error("SubjectLabelController.query.subjectLabelDTO出错: {}", e.getMessage(), e);
            return Result.fail("查询失败！");
        }
    }
}
