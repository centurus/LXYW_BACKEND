package com.lxyw.dao;

import com.lxyw.entity.customerInfo;
import org.apache.ibatis.annotations.Param;

public interface customerInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(customerInfo record);

    int insertSelective(customerInfo record);

    customerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(customerInfo record);

    int updateByPrimaryKey(customerInfo record);

    int batchInsert(@Param("list") java.util.List<customerInfo> list);
}