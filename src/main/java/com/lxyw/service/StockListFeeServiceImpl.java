package com.lxyw.service;

import com.lxyw.dao.StockListFeeMapper;
import com.lxyw.entity.StockListFee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stockListFeeService")
public class StockListFeeServiceImpl implements  StockListFeeService {

    @Resource
    private StockListFeeMapper stockListFeeMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return stockListFeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StockListFee record) {
        return stockListFeeMapper.insert(record);
    }

    @Override
    public int insertSelective(StockListFee record) {
        return stockListFeeMapper.insertSelective(record);
    }

    @Override
    public StockListFee selectByPrimaryKey(String id) {
        return stockListFeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StockListFee record) {
        return stockListFeeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StockListFee record) {
        return stockListFeeMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<StockListFee> list) {
        return stockListFeeMapper.batchInsert(list);
    }
}
