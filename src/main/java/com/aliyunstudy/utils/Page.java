package com.aliyunstudy.utils;

import java.util.List;

/**
 * Created by lvyihang on 17/5/9.
 */
public class Page {
    private List<?> list;
//    总页数
    private int totalCount;
    //当前页
    private int currentPage;
    //每页记录数
    private int pageSize;

    public List<?> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Page(List<?> list, int totalCount, int currentPage, int pageSize) {
        this.list = list;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
}
