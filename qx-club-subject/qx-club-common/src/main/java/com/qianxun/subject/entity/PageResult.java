package com.qianxun.subject.entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页响应实体
 */
@Data
public class PageResult<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
    private Integer totalPages;
    private List<T> records = Collections.emptyList();

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void setTotal(Integer total) {
        this.total = total;
        this.totalPages = total / pageSize + (total % pageSize > 0 ? 1 : 0);
    }
}
