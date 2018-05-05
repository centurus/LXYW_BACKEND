package com.lxyw.service;

import com.lxyw.entity.SupplierSubject;

import java.util.List;

public interface SupplierSubjectService {

    int deleteByPrimaryKey(String id);

    int insert(SupplierSubject record);

    int insertSelective(SupplierSubject record);

    SupplierSubject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierSubject record);

    int updateByPrimaryKey(SupplierSubject record);

    int batchInsert(List<SupplierSubject> list);
}
