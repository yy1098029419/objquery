package com.alipay.objquery.query;

/**
 * ��ҳ����������page��pageSize
 * @author yangwenpeng
 * @version 2020��9��3��17:45:10
 */
public class Limit {

    private int page;

    private int pageSize;

    public Limit() {
    }

    public Limit(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    /**
     * Gets the value of page.
     *
     * @return the value of page
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of page.
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Gets the value of pageSize.
     *
     * @return the value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of pageSize.
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
