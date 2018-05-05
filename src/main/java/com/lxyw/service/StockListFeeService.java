package com.lxyw.service;

import com.lxyw.entity.StockListFee;

import java.util.List;

public interface StockListFeeService {
    int deleteByPrimaryKey(String id);

    int insert(StockListFee record);

    int insertSelective(StockListFee record);

    StockListFee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockListFee record);

    int updateByPrimaryKey(StockListFee record);

    int batchInsert(List<StockListFee> list);
}
