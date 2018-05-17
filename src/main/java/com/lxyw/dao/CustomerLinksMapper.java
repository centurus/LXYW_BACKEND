package com.lxyw.dao;

import com.lxyw.entity.CustomerLinks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerLinksMapper {
    int deleteByPrimaryKey(String id);

    int insert(CustomerLinks record);

    int insertSelective(CustomerLinks record);

    CustomerLinks selectByPrimaryKey(String id);

    List<CustomerLinks> selectByCustomerId(String customerId);

    int updateByPrimaryKeySelective(CustomerLinks record);

    int updateByPrimaryKey(CustomerLinks record);

    int batchInsert(@Param("list") java.util.List<CustomerLinks> list);

    int detleteByCustomerId(@Param("customerId")String customerInfoId);


}