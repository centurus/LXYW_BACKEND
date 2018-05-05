package com.lxyw.service;

import com.lxyw.entity.StockList;

import java.util.List;

public interface StockListService {

    int deleteByPrimaryKey(String id);

    int insert(StockList record);

    int insertSelective(StockList record);

    StockList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockList record);

    int updateByPrimaryKey(StockList record);

    int batchInsert(List<StockList> list);
}
