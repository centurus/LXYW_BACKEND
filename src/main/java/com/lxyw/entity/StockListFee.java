package com.lxyw.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StockListFee {
    private String id;

    private String feeType;

    private BigDecimal feeNum;

    private String stockListId;

    private String createdBy;

    private Date createdDate;

    private String updateBy;

    private Date updateDate;

    private Long version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType == null ? null : feeType.trim();
    }

    public BigDecimal getFeeNum() {
        return feeNum;
    }

    public void setFeeNum(BigDecimal feeNum) {
        this.feeNum = feeNum;
    }

    public String getStockListId() {
        return stockListId;
    }

    public void setStockListId(String stockListId) {
        this.stockListId = stockListId == null ? null : stockListId.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}