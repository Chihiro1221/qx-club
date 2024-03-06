package com.qianxun.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.qianxun.subject.application.convert.SubjectInfoConverter;
import com.qianxun.subject.application.dto.SubjectInfoDTO;
import com.qianxun.subject.domain.bo.SubjectInfoBO;
import com.qianxun.subject.domain.service.SubjectInfoDomainService;
import com.qianxun.subject.entity.PageResult;
import com.qianxun.subject.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 刷题controller
 *
 * @author haonan
 */
@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    /**
     * 新增题目
     *
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/add")
    public Result addSubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.add.subjectInfoDTO: {}", JSON.toJSONString(subjectInfoDTO));
            }
            // 参数校验
            Preconditions.checkArgument(StringUtils.isNotBlank(subjectInfoDTO.getSubjectName()), "题目名不能为空！");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空！");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficulty(), "题目难度不能为空！");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空！");
            // dto转bo
            SubjectInfoBO subjectInfoBO = SubjectInfoConverter.INSTANCE.convertDtoToInfoBo(subjectInfoDTO);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("addSubjectInfo出现异常：{}", e);
            return Result.fail("添加失败！");
        }
    }

    /**
     * 查询题目（分页查询）
     *
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/queryList")
    public Result<PageResult<SubjectInfoDTO>> querySubjectInfoPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.query.subjectInfoDTO: {}", JSON.toJSONString(subjectInfoDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(), "题目分类不能为空！");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(), "题目标签不能为空！");
            // dto转bo
            SubjectInfoBO subjectInfoBO = SubjectInfoConverter.INSTANCE.convertDtoToInfoBo(subjectInfoDTO);
            PageResult subjectInfoBOPageResult = subjectInfoDomainService.queryPage(subjectInfoBO);
            // 将结果bo转换为dto
            List<SubjectInfoDTO> subjectInfoDTOS = SubjectInfoConverter.INSTANCE.convertBOListToInfoDTOList(subjectInfoBOPageResult.getRecords());
            subjectInfoBOPageResult.setRecords(subjectInfoDTOS);
            return Result.ok(subjectInfoBOPageResult);
        } catch (Exception e) {
            log.error("addSubjectInfo出现异常：{}", e);
            return Result.fail("查询失败！");
        }
    }


    /**
     * 查询题目详情
     *
     * @param subjectInfoDTO
     * @return
     */
    @PostMapping("/querySubject")
    public Result<SubjectInfoDTO> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectInfoController.querySubjectInfo.subjectInfoDTO: {}", JSON.toJSONString(subjectInfoDTO));
            }
            // 参数校验
            Preconditions.checkNotNull(subjectInfoDTO.getId(), "题目id不能为空！");
            // dto转bo
            SubjectInfoBO subjectInfoBO = SubjectInfoConverter.INSTANCE.convertDtoToInfoBo(subjectInfoDTO);
            SubjectInfoBO resultBo = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            // 将结果bo转换为dto
            SubjectInfoDTO subjectInfoDTOResult = SubjectInfoConverter.INSTANCE.convertBOToInfoDTO(resultBo);
            return Result.ok(subjectInfoDTOResult);
        } catch (Exception e) {
            log.error("querySubjectInfo出现异常：{}", e);
            return Result.fail("查询失败！");
        }
    }
}
