package com.lxyw.dao;

import com.lxyw.entity.StockList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockListMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(StockList record);

    StockList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockList record);

    int updateByPrimaryKey(StockList record);

    int batchInsert(@Param("list") java.util.List<StockList> list);

    List<StockList> selectStockListByCondition(@Param("condition")StockList stockList,@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);

    int selectStockListCountByCondition(@Param("condition")StockList stockList);
}