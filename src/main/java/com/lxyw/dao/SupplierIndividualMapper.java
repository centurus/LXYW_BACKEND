package com.lxyw.dao;

import com.lxyw.entity.SupplierIndividual;
import org.apache.ibatis.annotations.Param;

public interface SupplierIndividualMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupplierIndividual record);

    int insertSelective(SupplierIndividual record);

    SupplierIndividual selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupplierIndividual record);

    int updateByPrimaryKey(SupplierIndividual record);

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table supplier_individual
     *
     * @mbg.generated
     * @author hewei
     */
    int batchInsert(@Param("list") java.util.List<SupplierIndividual> list);

    int deleteBySupplierSubjectId(@Param("supplierSubjectId")String supplierSubjectId);
}