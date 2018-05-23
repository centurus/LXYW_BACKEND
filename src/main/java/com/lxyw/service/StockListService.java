package com.lxyw.service;

import com.lxyw.entity.StockList;
import com.lxyw.entityVo.StockListVo;
import com.lxyw.util.PageBean;

import java.util.List;

public interface StockListService {

    int deleteByPrimaryKey(String id);

    int insertSelective(StockList record);

    StockList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockList record);

    int batchInsert(List<StockList> list);

    PageBean<StockList> getStoclistPageInfo(StockList stockList,int startIndex,int pageSize);

    StockListVo selectAllStockInfoByPrimaryKey(String id);

}
