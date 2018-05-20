package com.lxyw.service;

import com.lxyw.entity.SupplierSubject;
import com.lxyw.util.PageBean;

import java.util.List;

public interface SupplierSubjectService {

    int deleteByPrimaryKey(String id);

    int insertSelective(SupplierSubject record);

    SupplierSubject selectByPrimaryKey(String id,boolean showSubInfo);

    int updateByPrimaryKeySelective(SupplierSubject record);

    int batchInsert(List<SupplierSubject> list);

    PageBean<SupplierSubject> getSupplierSubjectPageInfo(SupplierSubject record, int startIndex, int limit);
}
