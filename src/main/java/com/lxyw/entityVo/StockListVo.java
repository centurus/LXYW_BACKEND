package com.lxyw.entityVo;

import com.lxyw.entity.StockList;

public class StockListVo extends StockList {

    private Integer pageIndex;

    private Integer pageSize;

    private String stockManufactureDateStr;

    private String stockExpireDateStr;

    public String getStockManufactureDateStr() {
        return stockManufactureDateStr;
    }

    public void setStockManufactureDateStr(String stockManufactureDateStr) {
        this.stockManufactureDateStr = stockManufactureDateStr;
    }

    public String getStockExpireDateStr() {
        return stockExpireDateStr;
    }

    public void setStockExpireDateStr(String stockExpireDateStr) {
        this.stockExpireDateStr = stockExpireDateStr;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
