package com.qianxun.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.qianxun.subject.application.convert.SubjectCategoryConverter;
import com.qianxun.subject.application.dto.SubjectCategoryDTO;
import com.qianxun.subject.domain.bo.SubjectCategoryBO;
import com.qianxun.subject.domain.service.SubjectCategoryDomainService;
import com.qianxun.subject.entity.Result;
import com.qianxun.subject.infra.basic.entity.SubjectCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类controller
 *
 * @author haonan
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/add")
    public Result addSubjectCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.subjectCategoryDTO: {}", JSON.toJSONString(subjectCategoryDTO));
            }
            // 参数校验
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectCategoryDTO.getCategoryName()), "分类名不能为空！");
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空！");
            // dto转bo
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryConverter.INSTANCE.convertDtoToCategoryBo(subjectCategoryDTO);
            SubjectCategory category = subjectCategoryDomainService.add(subjectCategoryBO);

            Preconditions.checkNotNull(category);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("addSubjectCategory出现异常：{}", e);
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 新增分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/queryCategory")
    public Result<List<SubjectCategoryDTO>> queryCategoryByType(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.query.subjectCategoryDTO: {}", JSON.toJSONString(subjectCategoryDTO));
            }
            // dto转bo
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryConverter.INSTANCE.convertDtoToCategoryBo(subjectCategoryDTO);
            List<SubjectCategoryBO> categoryList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            // bo转dto
            List<SubjectCategoryDTO> boList = SubjectCategoryConverter.INSTANCE.convertBOToCategoryDTO(categoryList);
            Preconditions.checkNotNull(boList);
            return Result.ok(boList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.query.subjectCategoryDTO出错: {}", e.getMessage(), e);
            return Result.fail("查询失败！");
        }
    }

    /**
     * 更新分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.update.subjectCategoryDTO: {}", JSON.toJSONString(subjectCategoryDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");
            // dto转bo
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryConverter.INSTANCE.convertDtoToCategoryBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.query.subjectCategoryDTO出错: {}", e.getMessage(), e);
            return Result.fail("更新失败！");
        }
    }

    /**
     * 删除分类
     *
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.subjectCategoryDTO: {}", JSON.toJSONString(subjectCategoryDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectCategoryDTO.getId(), "id不能为空");
            // dto转bo
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryConverter.INSTANCE.convertDtoToCategoryBo(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.subjectCategoryDTO出错: {}", e.getMessage(), e);
            return Result.fail("删除失败！");
        }
    }
}
