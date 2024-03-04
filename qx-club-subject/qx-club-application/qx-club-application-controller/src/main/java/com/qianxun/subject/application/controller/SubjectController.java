package com.qianxun.subject.application.controller;

import com.qianxun.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 刷题controller
 *
 * @author haonan
 */
@RestController
public class SubjectController {
    @Resource
    private SubjectCategoryService subjectCategoryService;
    @GetMapping("test")
    public String test() {
        return subjectCategoryService.queryById(1L).getCategoryName();
    }
}
