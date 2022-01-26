package com.wangshidai.eshopFront.pojo;

import java.util.List;

public class PageInfo<E> {
    private int currentPage;
    private int totalPage;
    private long totalSize;
    private int pageSize;

    private List<E> currentPageData;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<E> getCurrentPageData() {
        return currentPageData;
    }

    public void setCurrentPageData(List<E> currentPageData) {
        this.currentPageData = currentPageData;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                ", pageSize=" + pageSize +
                ", currentPageData=" + currentPageData +
                '}';
    }
}
