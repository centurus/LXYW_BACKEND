package com.lxyw.service;

import com.lxyw.dao.SupplierSubjectMapper;
import com.lxyw.entity.SupplierSubject;
import com.lxyw.util.PageBean;
import com.lxyw.util.PrimaryKeyGenerator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("supplierSubjectService")
public class SupplierSubjectServiceImpl implements  SupplierSubjectService {

    @Resource
    private SupplierSubjectMapper supplierSubjectMapper;

    @Resource
    private SupplierIndividualService supplierIndividualService;

    /**
     * 供应商主子表删除
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String id) {
        //先删除字表
        supplierIndividualService.deleteBySupplierSubjectId(id);
        //再删除主表
        return supplierSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SupplierSubject record) {
        return supplierSubjectMapper.insert(record);
    }

    /**
     * 供应商主子表新增
     * @param record
     * @return
     */
    @Override
    public int insertSelective(SupplierSubject record) {
        String supplierSubjectId = PrimaryKeyGenerator.getPrimaryKey();
        if(!record.getSupplierIndividualList().isEmpty()){
            supplierIndividualService.batchInsert(record.getSupplierIndividualList(),supplierSubjectId);
        }
        record.setId(supplierSubjectId);
        return supplierSubjectMapper.insertSelective(record);
    }

    @Override
    public SupplierSubject selectByPrimaryKey(String id) {
        return supplierSubjectMapper.selectByPrimaryKey(id);
    }

    /**
     * 供应商主子表修改
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(SupplierSubject record) {
        //先删除字表
        supplierIndividualService.deleteBySupplierSubjectId(record.getId());
        //再新增字表
        supplierIndividualService.batchInsert(record.getSupplierIndividualList(),record.getId());
        //最后更新主表
        return supplierSubjectMapper.updateByPrimaryKeySelective(record);}

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
