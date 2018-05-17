package com.lxyw.service;

import com.lxyw.dao.SupplierSubjectMapper;
import com.lxyw.entity.SupplierSubject;
import com.lxyw.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("supplierSubjectService")
public class SupplierSubjectServiceImpl implements  SupplierSubjectService {

    @Resource
    private SupplierSubjectMapper supplierSubjectMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return supplierSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SupplierSubject record) {
        return supplierSubjectMapper.insert(record);
    }

    @Override
    public int insertSelective(SupplierSubject record) {
        return supplierSubjectMapper.insertSelective(record);
    }

    @Override
    public SupplierSubject selectByPrimaryKey(String id) {
        return supplierSubjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SupplierSubject record) {return supplierSubjectMapper.updateByPrimaryKeySelective(record);}

    @Override
    public int updateByPrimaryKey(SupplierSubject record) {
        return supplierSubjectMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SupplierSubject> list) {
        return supplierSubjectMapper.batchInsert(list);
    }

    @Override
    public PageBean<SupplierSubject> getSupplierSubjectPageInfo(SupplierSubject record, int startIndex, int limit) {
        PageBean<SupplierSubject> supplierSubjectPageBean=new PageBean<>();
        List<SupplierSubject> supplierSubjectList=supplierSubjectMapper.selectSupplierSubjectoListByCondition(record,startIndex,limit);
        int count=supplierSubjectMapper.selectSupplierSubjectCountByCondition(record);
        supplierSubjectPageBean.setList(supplierSubjectList);
        supplierSubjectPageBean.setTotalSize(count);
        return supplierSubjectPageBean;
    }
}
