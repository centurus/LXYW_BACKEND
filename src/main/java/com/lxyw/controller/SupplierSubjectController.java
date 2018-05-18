package com.lxyw.controller;

import com.lxyw.entity.SupplierSubject;
import com.lxyw.entityVo.SupplierSubjectVo;
import com.lxyw.service.SupplierSubjectService;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;
import com.lxyw.util.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/supplierSubject")
public class SupplierSubjectController {

    @Resource
    private SupplierSubjectService supplierSubjectService;

    /**
     * 供应商查询分页查询
     * @param supplierSubjectVo
     * @return
     */
    @RequestMapping(value="/getSupplierSubjectPageInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getSupplierSubjectPageInfo(@RequestBody SupplierSubjectVo supplierSubjectVo){
        Response response=new Response();
        SupplierSubject supplierSubject=new SupplierSubject();
        supplierSubject.setSupplierName(supplierSubjectVo.getSupplierName());
        PageBean<SupplierSubject> supplierSubjectPageInfos=supplierSubjectService.getSupplierSubjectPageInfo(supplierSubject,supplierSubjectVo.getPageIndex(),supplierSubjectVo.getPageSize());
        response.setData(supplierSubjectPageInfos);
        return response;
    }

    /**
     * 供应商信息添加
     * @param supplierSubject
     * @return
     */
    @RequestMapping(value="/addSupplierSubject", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addSupplierSubject(@RequestBody SupplierSubject supplierSubject){
        Response response=new Response();
        if(supplierSubject==null||StringUtils.isEmpty(supplierSubject.getSupplierName())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.supplierSubjectService.insert(supplierSubject);
        }
        return response;
    }

    /**
     * 供应商信息修改
     * @param supplierSubject
     * @return
     */
    @RequestMapping(value="/updateSupplierSubject", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateSupplierSubject(@RequestBody SupplierSubject supplierSubject){
        Response response=new Response();
        if(supplierSubject==null||StringUtils.isEmpty(supplierSubject.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.supplierSubjectService.updateByPrimaryKeySelective(supplierSubject);
        }
        return  response;
    }

    /**
     * 供应商删除
     * @param supplierSubject
     * @return
     */
    @RequestMapping(value="/deleteSupplierSubject", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response deleteSupplierSubject(@RequestBody SupplierSubject supplierSubject){
        Response response=new Response();
        if(supplierSubject==null||StringUtils.isEmpty(supplierSubject.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.supplierSubjectService.deleteByPrimaryKey(supplierSubject.getId());
        }
        return response;
    }


}
