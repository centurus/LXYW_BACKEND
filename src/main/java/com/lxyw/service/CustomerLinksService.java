package com.lxyw.service;

import com.lxyw.entity.CustomerLinks;

import java.util.List;

public interface CustomerLinksService {

    int deleteByPrimaryKey(String id);

    int insert(CustomerLinks record);

    int insertSelective(CustomerLinks record);

    CustomerLinks selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerLinks record);

    int updateByPrimaryKey(CustomerLinks record);

    int batchInsert(List<CustomerLinks> list);
}
