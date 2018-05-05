package com.lxyw.service;

import com.lxyw.entity.customerInfo;

import java.util.List;

public interface CustomerInfoService {

    int deleteByPrimaryKey(String id);

    int insert(customerInfo record);

    int insertSelective(customerInfo record);

    customerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(customerInfo record);

    int updateByPrimaryKey(customerInfo record);

    int batchInsert( List<customerInfo> list);
}
