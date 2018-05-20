package com.lxyw.dao;

import com.lxyw.entity.StockListFee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockListFeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(StockListFee record);

    int insertSelective(StockListFee record);

    StockListFee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockListFee record);

    int updateByPrimaryKey(StockListFee record);

    int batchInsert(@Param("list") java.util.List<StockListFee> list);

    /**
     * 通过stockList主键删除
     * @param id
     * @return
     */
    int deleteByStockListId(@Param("stockListId")String stockListId);

    /**
     * 通过stockListid获取stockListFee对象
     * @param id
     * @return
     */
    List<StockListFee> getStockListFeeByStockListId(@Param("stockListId")String stockListId);
}