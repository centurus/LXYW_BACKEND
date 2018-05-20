package com.lxyw.dao;

import com.lxyw.entity.SupplierIndividual;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierIndividualMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierIndividual record);

    int insertSelective(SupplierIndividual record);

    SupplierIndividual selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierIndividual record);

    int updateByPrimaryKey(SupplierIndividual record);

    int batchInsert(@Param("list") java.util.List<SupplierIndividual> list);

    int deleteBySupplierSubjectId(@Param("supplierSubjectId")String supplierSubjectId);

    List<SupplierIndividual> getSupplierIndividualListBySubjectId(@Param("supplierSubjectId")String supplierSubjectId);
}