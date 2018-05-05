package com.lxyw.dao;

import com.lxyw.entity.CustomerLinks;
import org.apache.ibatis.annotations.Param;

public interface CustomerLinksMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerLinks record);

    int insertSelective(CustomerLinks record);

    CustomerLinks selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CustomerLinks record);

    int updateByPrimaryKey(CustomerLinks record);

    int batchInsert(@Param("list") java.util.List<CustomerLinks> list);
}