package com.lxyw.dao;

import com.lxyw.entity.SupplierSubject;
import org.apache.ibatis.annotations.Param;

public interface SupplierSubjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierSubject record);

    int insertSelective(SupplierSubject record);

    SupplierSubject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierSubject record);

    int updateByPrimaryKey(SupplierSubject record);

    int batchInsert(@Param("list") java.util.List<SupplierSubject> list);
}