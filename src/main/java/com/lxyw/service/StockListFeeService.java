package com.lxyw.service;

import com.lxyw.entity.StockListFee;

import java.util.List;

public interface StockListFeeService {
    int deleteByPrimaryKey(String id);

    int insertSelective(StockListFee record);

    StockListFee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockListFee record);

    int batchInsert(List<StockListFee> list,String stockListId);

    List<StockListFee> getStockListFeeByStockListId(String id);

    /**
     * 通过主表主键删除
     * @param id
     * @return
     */
    int deleteByStockListId(String id);
}
