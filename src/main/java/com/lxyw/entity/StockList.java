package com.lxyw.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StockList {
    private String id;

    private String stockProductName;

    private String stockProductQno;

    private String stockProductLocation;

    private BigDecimal stockProductNum;

    private String stockProductPosition;

    private BigDecimal stockProductPlusNum;

    private String stockProductPlusPosition;

    private BigDecimal stockProductFormatNum;

    private String stockProductGuaranteeTime;

    private BigDecimal stockProductSingleNetweight;

    private BigDecimal stockProductSingleCapacity;

    private String stockProductBatch;

    private String stockProductStatus;

    private String stockProductStorage;

    private BigDecimal stockProductWastage;

    private BigDecimal stockProductStorageFee;

    private String stockProductSupplierSubjectId;

    private Date stockManufactureDate;

    private Date stockExpireDate;

    private String createdBy;

    private Date createdDate;

    private String updateBy;

    private Date updateDate;

    private Long version;

    private List<StockListFee> stockListFeeList;

    private String supplierSubjectName;

    private String startDate;

    private String endDate;


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSupplierSubjectName() {
        return supplierSubjectName;
    }

    public void setSupplierSubjectName(String supplierSubjectName) {
        this.supplierSubjectName = supplierSubjectName;
    }

    public List<StockListFee> getStockListFeeList() {
        return stockListFeeList;
    }

    public void setStockListFeeList(List<StockListFee> stockListFeeList) {
        this.stockListFeeList = stockListFeeList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStockProductName() {
        return stockProductName;
    }

    public void setStockProductName(String stockProductName) {
        this.stockProductName = stockProductName == null ? null : stockProductName.trim();
    }

    public String getStockProductQno() {
        return stockProductQno;
    }

    public void setStockProductQno(String stockProductQno) {
        this.stockProductQno = stockProductQno == null ? null : stockProductQno.trim();
    }

    public String getStockProductLocation() {
        return stockProductLocation;
    }

    public void setStockProductLocation(String stockProductLocation) {
        this.stockProductLocation = stockProductLocation == null ? null : stockProductLocation.trim();
    }

    public BigDecimal getStockProductNum() {
        return stockProductNum;
    }

    public void setStockProductNum(BigDecimal stockProductNum) {
        this.stockProductNum = stockProductNum;
    }

    public String getStockProductPosition() {
        return stockProductPosition;
    }

    public void setStockProductPosition(String stockProductPosition) {
        this.stockProductPosition = stockProductPosition == null ? null : stockProductPosition.trim();
    }

    public BigDecimal getStockProductPlusNum() {
        return stockProductPlusNum;
    }

    public void setStockProductPlusNum(BigDecimal stockProductPlusNum) {
        this.stockProductPlusNum = stockProductPlusNum;
    }

    public String getStockProductPlusPosition() {
        return stockProductPlusPosition;
    }

    public void setStockProductPlusPosition(String stockProductPlusPosition) {
        this.stockProductPlusPosition = stockProductPlusPosition == null ? null : stockProductPlusPosition.trim();
    }

    public BigDecimal getStockProductFormatNum() {
        return stockProductFormatNum;
    }

    public void setStockProductFormatNum(BigDecimal stockProductFormatNum) {
        this.stockProductFormatNum = stockProductFormatNum;
    }

    public String getStockProductGuaranteeTime() {
        return stockProductGuaranteeTime;
    }

    public void setStockProductGuaranteeTime(String stockProductGuaranteeTime) {
        this.stockProductGuaranteeTime = stockProductGuaranteeTime == null ? null : stockProductGuaranteeTime.trim();
    }

    public BigDecimal getStockProductSingleNetweight() {
        return stockProductSingleNetweight;
    }

    public void setStockProductSingleNetweight(BigDecimal stockProductSingleNetweight) {
        this.stockProductSingleNetweight = stockProductSingleNetweight;
    }

    public BigDecimal getStockProductSingleCapacity() {
        return stockProductSingleCapacity;
    }

    public void setStockProductSingleCapacity(BigDecimal stockProductSingleCapacity) {
        this.stockProductSingleCapacity = stockProductSingleCapacity;
    }

    public String getStockProductBatch() {
        return stockProductBatch;
    }

    public void setStockProductBatch(String stockProductBatch) {
        this.stockProductBatch = stockProductBatch == null ? null : stockProductBatch.trim();
    }

    public String getStockProductStatus() {
        return stockProductStatus;
    }

    public void setStockProductStatus(String stockProductStatus) {
        this.stockProductStatus = stockProductStatus == null ? null : stockProductStatus.trim();
    }

    public String getStockProductStorage() {
        return stockProductStorage;
    }

    public void setStockProductStorage(String stockProductStorage) {
        this.stockProductStorage = stockProductStorage == null ? null : stockProductStorage.trim();
    }

    public BigDecimal getStockProductWastage() {
        return stockProductWastage;
    }

    public void setStockProductWastage(BigDecimal stockProductWastage) {
        this.stockProductWastage = stockProductWastage;
    }

    public BigDecimal getStockProductStorageFee() {
        return stockProductStorageFee;
    }

    public void setStockProductStorageFee(BigDecimal stockProductStorageFee) {
        this.stockProductStorageFee = stockProductStorageFee;
    }

    public String getStockProductSupplierSubjectId() {
        return stockProductSupplierSubjectId;
    }

    public void setStockProductSupplierSubjectId(String stockProductSupplierSubjectId) {
        this.stockProductSupplierSubjectId = stockProductSupplierSubjectId == null ? null : stockProductSupplierSubjectId.trim();
    }

    public Date getStockManufactureDate() {
        return stockManufactureDate;
    }

    public void setStockManufactureDate(Date stockManufactureDate) {
        this.stockManufactureDate = stockManufactureDate;
    }

    public Date getStockExpireDate() {
        return stockExpireDate;
    }

    public void setStockExpireDate(Date stockExpireDate) {
        this.stockExpireDate = stockExpireDate;
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