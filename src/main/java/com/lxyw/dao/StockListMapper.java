package com.lxyw.dao;

import com.lxyw.entity.StockList;

public interface StockListMapper {
    int deleteByPrimaryKey(String id);

    int insert(StockList record);

    int insertSelective(StockList record);

    StockList selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockList record);

    int updateByPrimaryKey(StockList record);

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table stock_list
     *
     * @mbg.generated
     * @author hewei
     */
    int batchInsert(@Param("list") java.util.List<StockList> list);
}