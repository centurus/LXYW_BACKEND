package com.lxyw.controller;

import com.lxyw.entity.SupplierSubject;
import com.lxyw.entityVo.SupplierSubjectVo;
import com.lxyw.service.SupplierSubjectService;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;
import org.springframework.stereotype.Controller;
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
     * 客户信息分页查询
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

}
