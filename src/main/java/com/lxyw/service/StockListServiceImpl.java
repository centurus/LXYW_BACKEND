package com.lxyw.service;

import com.lxyw.dao.StockListMapper;
import com.lxyw.entity.StockList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stockListService")
public class StockListServiceImpl implements  StockListService {
    @Resource
    private StockListMapper stockListMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return stockListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StockList record) {
        return stockListMapper.insert(record);
    }

    @Override
    public int insertSelective(StockList record) {
        return stockListMapper.insertSelective(record);
    }

    @Override
    public StockList selectByPrimaryKey(String id) {
        return stockListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StockList record) {
        return stockListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StockList record) {
        return stockListMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<StockList> list) {
        return stockListMapper.batchInsert(list);
    }
}
