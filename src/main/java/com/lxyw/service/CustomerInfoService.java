package com.lxyw.service;

import com.lxyw.entity.CustomerInfo;

import java.util.List;

public interface CustomerInfoService {

    int deleteByPrimaryKey(String id);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    CustomerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);

    int batchInsert( List<CustomerInfo> list);
}
