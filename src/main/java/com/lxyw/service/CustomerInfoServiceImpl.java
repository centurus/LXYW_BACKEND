package com.lxyw.service;

import com.lxyw.dao.CustomerInfoMapper;
import com.lxyw.entity.CustomerInfo;
import com.lxyw.entityVo.CustomerInfoAndLinksVo;
import com.lxyw.util.PageBean;
import com.lxyw.util.PrimaryKeyGenerator;
import com.lxyw.util.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("customerInfoService")
public class CustomerInfoServiceImpl implements  CustomerInfoService {

    @Resource
    private CustomerInfoMapper customerInfoMapper;

    @Resource
    private CustomerLinksService customerLinksService;
    @Override
    public int deleteByPrimaryKey(String id) {
        return customerInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Response insertSelective(CustomerInfoAndLinksVo record) {
        Response response=new Response();
        record.setId(PrimaryKeyGenerator.getPrimaryKey());
        customerInfoMapper.insertSelective(record);
        customerLinksService.batchInsert(record.getCustomerLinks());
        return response;
    }

    @Override
    public CustomerInfo selectByPrimaryKey(String id) {
        return customerInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(CustomerInfo record) {
        return customerInfoMapper.updateByPrimaryKeySelective(record);
    }

    /*@Override
    public int updateByPrimaryKey(CustomerInfo record) {
        return customerInfoMapper.updateByPrimaryKey(record);
    }*/

    @Override
    public int batchInsert(List<CustomerInfo> list) {
        return customerInfoMapper.batchInsert(list);
    }

    @Override
    public PageBean<CustomerInfo> getCustomerInfoPageInfo(CustomerInfo record, int startIndex, int limit) {
        PageBean<CustomerInfo> customerInfoPageBean=new PageBean<>();
        List<CustomerInfo> customerInfoList=customerInfoMapper.selectCustomerInfoListByCondition(record,startIndex,limit);
        int count=customerInfoMapper.selectCustomerInfoLCountByCondition(record);
        customerInfoPageBean.setList(customerInfoList);
        customerInfoPageBean.setTotalSize(count);
        return customerInfoPageBean;
    }
}
