package com.lxyw.dao;

import com.lxyw.entity.StockList;
import org.apache.ibatis.annotations.Param;

public interface StockListMapper {
    int deleteByPrimaryKey(String id);

    int insert(StockList record);

    int insertSelective(StockList record);

    StockList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockList record);

    int updateByPrimaryKey(StockList record);

    int batchInsert(@Param("list") java.util.List<StockList> list);
}