package com.lxyw.service;

import com.lxyw.entity.SupplierIndividual;

import java.util.List;

public interface SupplierIndividualService {
    int deleteByPrimaryKey(String id);

    int insert(SupplierIndividual record);

    int insertSelective(SupplierIndividual record);

    SupplierIndividual selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierIndividual record);

    int updateByPrimaryKey(SupplierIndividual record);

    int batchInsert(List<SupplierIndividual> list,String supplierSubjectID);

    int deleteBySupplierSubjectId(String supplierSubjectId);

    List<SupplierIndividual> getSupplierIndividualListBySubjectId(String supplierSubjectId);
}
