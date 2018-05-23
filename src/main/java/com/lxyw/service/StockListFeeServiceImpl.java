package com.lxyw.service;

import com.lxyw.dao.StockListFeeMapper;
import com.lxyw.entity.StockListFee;
import com.lxyw.util.PageBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("stockListFeeService")
public class StockListFeeServiceImpl implements  StockListFeeService {

    @Resource
    private StockListFeeMapper stockListFeeMapper;

    /**
     *
     * 通过库存id删除库存主子表信息
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        return stockListFeeMapper.deleteByPrimaryKey(id);
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
    public int batchInsert(List<StockListFee> list,String stockListId) {
        for(StockListFee fee:list){
            fee.setStockListId(stockListId);
        }
        return stockListFeeMapper.batchInsert(list);
    }

    @Override
    public List<StockListFee> getStockListFeeByStockListId(String stockListId) {
        return stockListFeeMapper.getStockListFeeByStockListId(stockListId);
    }

    @Override
    public int deleteByStockListId(String id) {
        return stockListFeeMapper.deleteByStockListId(id);
    }

}
