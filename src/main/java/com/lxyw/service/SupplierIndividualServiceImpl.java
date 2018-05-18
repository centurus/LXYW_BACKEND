package com.lxyw.service;

import com.lxyw.dao.SupplierIndividualMapper;
import com.lxyw.entity.SupplierIndividual;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("supplierIndividualService")
public class SupplierIndividualServiceImpl implements  SupplierIndividualService {

    @Resource
    private SupplierIndividualMapper supplierIndividualMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return supplierIndividualMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SupplierIndividual record) {
        return supplierIndividualMapper.insert(record);
    }

    @Override
    public int insertSelective(SupplierIndividual record) {
        return supplierIndividualMapper.insertSelective(record);
    }

    @Override
    public SupplierIndividual selectByPrimaryKey(String id) {
        return supplierIndividualMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SupplierIndividual record) {
        return supplierIndividualMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SupplierIndividual record) {
        return supplierIndividualMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SupplierIndividual> list,String supplierSubjectID) {
        for(SupplierIndividual si:list){
            si.setSupplierSubjectId(supplierSubjectID);
        }
        return supplierIndividualMapper.batchInsert(list);
    }

    @Override
    public int deleteBySupplierSubjectId(String supplierSubjectId) {
        return supplierIndividualMapper.deleteBySupplierSubjectId(supplierSubjectId);
    }
}
