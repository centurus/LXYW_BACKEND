package com.lxyw.dao;

import com.lxyw.entity.SupplierSubject;

public interface SupplierSubjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierSubject record);

    int insertSelective(SupplierSubject record);

    SupplierSubject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierSubject record);

    int updateByPrimaryKey(SupplierSubject record);

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table supplier_subject
     *
     * @mbg.generated
     * @author hewei
     */
    int batchInsert(@Param("list") java.util.List<SupplierSubject> list);
}