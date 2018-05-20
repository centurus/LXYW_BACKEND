package com.lxyw.service;

import com.lxyw.dao.StockListMapper;
import com.lxyw.entity.StockList;
import com.lxyw.entity.StockListFee;
import com.lxyw.entity.SupplierSubject;
import com.lxyw.entityVo.StockListVo;
import com.lxyw.util.DateUtil;
import com.lxyw.util.PageBean;
import com.lxyw.util.PrimaryKeyGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("stockListService")
public class StockListServiceImpl implements  StockListService {
    @Resource
    private StockListMapper stockListMapper;

    @Resource
    private StockListFeeService stockListFeeService;

    @Resource
    private SupplierSubjectService supplierSubjectService;

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String id) {
        //先删除字表
        stockListFeeService.deleteByStockListId(id);
        //再删除主表
        return stockListMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int insertSelective(StockList record) {
        String id = PrimaryKeyGenerator.getPrimaryKey();
        record.setId(id);
        int result=stockListMapper.insertSelective(record);
        if(record.getStockListFeeList()!=null&&!record.getStockListFeeList().isEmpty()){
            stockListFeeService.batchInsert(record.getStockListFeeList(),id);
        }
        return result;
    }

    @Override
    public StockList selectByPrimaryKey(String id) {
        StockList stockList;
        stockList=stockListMapper.selectByPrimaryKey(id);
       /* List<StockListFee> stockListFees=stockListFeeService.getStockListFeeByStockListId(id);
        stockList.setStockListFeeList(stockListFees);*/
        return stockList;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(StockList record) {
        stockListFeeService.deleteByStockListId(record.getId());
        stockListFeeService.batchInsert(record.getStockListFeeList(),record.getId());
        return stockListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int batchInsert(List<StockList> list) {
        return stockListMapper.batchInsert(list);
    }

    /**
     * stockList分页查询
     * @param stockList
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<StockList> getStoclistPageInfo(StockList stockList, int startIndex, int pageSize) {
        PageBean<StockList> stockListPageBean=new PageBean<>();
        List<StockList> stockLists=stockListMapper.selectStockListByCondition(stockList,startIndex,pageSize);
        for(StockList stock:stockLists){
            SupplierSubject subject=supplierSubjectService.selectByPrimaryKey(stock.getStockProductSupplierSubjectId(),false);
            stock.setSupplierSubjectName(subject.getSupplierName());
        }
        int count=stockListMapper.selectStockListCountByCondition(stockList);
        stockListPageBean.setList(stockLists);stockListPageBean.setTotalSize(count);
        return stockListPageBean;
    }

    /**
     * 通过id查询库存所有信息，
     * 包括字表和供应商名称
     * @param id
     * @return
     */
    @Override
    public StockListVo selectAllStockInfoByPrimaryKey(String id) {
        StockList stockList;
        stockList=stockListMapper.selectByPrimaryKey(id);
        StockListVo stockListVo=new StockListVo();
        BeanUtils.copyProperties(stockList,stockListVo);
        //返回时间格式化
        stockListVo.setStockManufactureDateStr(DateUtil.DateFormat_YMD(stockList.getStockManufactureDate()));
        stockListVo.setStockExpireDateStr(DateUtil.DateFormat_YMD(stockList.getStockExpireDate()));
        //查询字表信息
        List<StockListFee> stockListFees=stockListFeeService.getStockListFeeByStockListId(id);
        for(StockListFee fee:stockListFees){
            fee.setPayDateStr(fee.getPayDate()==null?"":DateUtil.DateFormat_YMD(fee.getPayDate()));
        }
        stockListVo.setStockListFeeList(stockListFees);
        //查询供应商名称
        SupplierSubject subject=supplierSubjectService.selectByPrimaryKey(stockList.getStockProductSupplierSubjectId(),false);
        if(subject!=null){
            stockListVo.setSupplierSubjectName(subject.getSupplierName());
        }
        return stockListVo;
    }

}
