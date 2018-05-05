package com.lxyw.dao;

import com.lxyw.entity.CustomerInfo;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    CustomerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);

    int batchInsert(@Param("list") java.util.List<CustomerInfo> list);
}