package com.lxyw.dao;

import com.lxyw.entity.StockListFee;
import org.apache.ibatis.annotations.Param;

public interface StockListFeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(StockListFee record);

    int insertSelective(StockListFee record);

    StockListFee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StockListFee record);

    int updateByPrimaryKey(StockListFee record);

    int batchInsert(@Param("list") java.util.List<StockListFee> list);
}