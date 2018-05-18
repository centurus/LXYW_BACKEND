package com.lxyw.entity;

import java.util.Date;
import java.util.List;

public class SupplierSubject {
    private String id;

    private String supplierName;

    private String supplierType;

    private String supplierEmail;

    private String supplierLocation;

    private String supplierCellphone;

    private String supplierAddress;

    private String supplierRemark;

    private String createdBy;

    private Date createdDate;

    private String updateBy;

    private Date updateDate;

    private Long version;

    private String status;

    private List<SupplierIndividual> SupplierIndividualList;

    public String getId() {
        return id;
    }

    public List<SupplierIndividual> getSupplierIndividualList() {
        return SupplierIndividualList;
    }

    public void setSupplierIndividualList(List<SupplierIndividual> supplierIndividualList) {
        SupplierIndividualList = supplierIndividualList;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType == null ? null : supplierType.trim();
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail == null ? null : supplierEmail.trim();
    }

    public String getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(String supplierLocation) {
        this.supplierLocation = supplierLocation == null ? null : supplierLocation.trim();
    }

    public String getSupplierCellphone() {
        return supplierCellphone;
    }

    public void setSupplierCellphone(String supplierCellphone) {
        this.supplierCellphone = supplierCellphone == null ? null : supplierCellphone.trim();
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
    }

    public String getSupplierRemark() {
        return supplierRemark;
    }

    public void setSupplierRemark(String supplierRemark) {
        this.supplierRemark = supplierRemark == null ? null : supplierRemark.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}