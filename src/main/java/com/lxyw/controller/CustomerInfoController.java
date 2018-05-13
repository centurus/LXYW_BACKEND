package com.lxyw.controller;


import com.lxyw.entity.CustomerInfo;
import com.lxyw.service.CustomerInfoService;
import com.lxyw.util.Response;
import com.lxyw.util.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/customerInfo")
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoService;

    /**
     * 通过主键查找customerInfo
     * @param customerInfo
     * @return
     */
    @RequestMapping(value="/findCustomerInfoByPrimaryKey", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response showCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        CustomerInfo customerInfoResult=this.customerInfoService.selectByPrimaryKey(customerInfo.getId());
        response.setData(customerInfoResult);
        return response;
    }

    /**
     * 添加供应商
     * @param customerInfo
     * @return
     */
    @RequestMapping(value="/addCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        if(customerInfo==null|| StringUtils.isEmpty(customerInfo.getCustomerName())||StringUtils.isEmpty(customerInfo.getCustomerType())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.insert(customerInfo);
        }
        return response;
    }

    /**
     * 通过主键更新供应商信息
     * @param customerInfo
     * @return
     */
    @RequestMapping(value="/updateCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        customerInfo.setUpdateDate(new Date());
        if(customerInfo==null|| StringUtils.isEmpty(customerInfo.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.updateByPrimaryKeySelective(customerInfo);
        }
        return response;
    }

    /**
     * 通过主键删除供应商信息
     * @param customerInfo
     * @return
     */
    @RequestMapping(value="/deleteCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response deleteCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        if(customerInfo==null|| StringUtils.isEmpty(customerInfo.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.deleteByPrimaryKey(customerInfo.getId());
        }
        return response;
    }




}
