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
    public int updateByPrimaryKeySelective(CustomerLinks record) {
        return customerLinksMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CustomerLinks record) {
        return customerLinksMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<CustomerLinks> list) {
        for(CustomerLinks customerLink:list){
            customerLink.setId(PrimaryKeyGenerator.getPrimaryKey());
        }
        return customerLinksMapper.batchInsert(list);
    }

    @Override
    public int deleteByCustomerId(String customerId) {
        return customerLinksMapper.deteleByCustomerId(customerId);
    }
}
