package com.lxyw.service;

import com.lxyw.dao.CustomerInfoMapper;
import com.lxyw.entity.CustomerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerInfoService")
public class CustomerInfoServiceImpl implements  CustomerInfoService {

    @Resource
    private CustomerInfoMapper customerInfoMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return customerInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CustomerInfo record) {
        return customerInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(CustomerInfo record) {
        return customerInfoMapper.insertSelective(record);
    }

    @Override
    public CustomerInfo selectByPrimaryKey(String id) {
        return customerInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerInfo record) {
        return customerInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CustomerInfo record) {
        return customerInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<CustomerInfo> list) {
        return customerInfoMapper.batchInsert(list);
    }
}
