package com.lxyw.service;

import com.lxyw.entity.CustomerInfo;
import com.lxyw.entity.UserInfo;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;

import java.util.List;

public interface CustomerInfoService {

    int deleteByPrimaryKey(String id);

    Response insert(CustomerInfo record);

    CustomerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);

    int batchInsert( List<CustomerInfo> list);

    Response insertSelective(CustomerInfo record);

    PageBean<CustomerInfo> getCustomerInfoPageInfo(CustomerInfo record, int startIndex, int limit);
}
