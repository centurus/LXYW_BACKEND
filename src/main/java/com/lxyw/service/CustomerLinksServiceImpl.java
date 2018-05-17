package com.lxyw.service;

import com.lxyw.dao.CustomerLinksMapper;
import com.lxyw.entity.CustomerLinks;
import com.lxyw.util.PrimaryKeyGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerLinksService")
public class CustomerLinksServiceImpl implements CustomerLinksService{
    @Resource
    private CustomerLinksMapper customerLinksMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return customerLinksMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CustomerLinks record) {
        return customerLinksMapper.insert(record);
    }

    @Override
    public int insertSelective(CustomerLinks record) {
        return customerLinksMapper.insertSelective(record);
    }

    @Override
    public CustomerLinks selectByPrimaryKey(String id) {
        return customerLinksMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CustomerLinks> selectByCustomerId(String customerId) {
        return customerLinksMapper.selectByCustomerId(customerId);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerLinks record) {
        return customerLinksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CustomerLinks record) {
        return customerLinksMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<CustomerLinks> list,String customerInfoId) {
        for(CustomerLinks customerLink:list){
            customerLink.setId(PrimaryKeyGenerator.getPrimaryKey());
            //子表关联主表ID
            customerLink.setCustomerInfoId(customerInfoId);
        }
        return customerLinksMapper.batchInsert(list);
    }

    @Override
    public int deleteByCustomerId(String customerId) {
        return customerLinksMapper.detleteByCustomerId(customerId);
    }
}
