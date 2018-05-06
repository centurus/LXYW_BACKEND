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

    /**
     * 这是Mybatis Generator拓展插件生成的方法(请勿删除).
     * This method corresponds to the database table stock_list_fee
     *
     * @mbg.generated
     * @author hewei
     */
    int batchInsert(@Param("list") java.util.List<StockListFee> list);
}