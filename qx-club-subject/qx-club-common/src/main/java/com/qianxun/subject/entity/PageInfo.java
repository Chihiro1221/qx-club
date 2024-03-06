package com.qianxun.subject.entity;

import lombok.Data;

/**
 * 分页请求实体
 */
@Data
public class PageInfo {
    private Integer currentPage;
    private Integer pageSize;

    public Integer getCurrentPage() {
        if (currentPage == null || currentPage <= 0) return 1;
        return currentPage;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) return 10;
        return pageSize;
    }
}
