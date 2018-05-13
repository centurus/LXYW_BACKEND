package com.lxyw.controller;


import com.lxyw.entity.CustomerInfo;
import com.lxyw.service.CustomerInfoService;
import com.lxyw.util.Response;
import com.lxyw.util.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/customerInfo")
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoService;

    @RequestMapping("/showCustomerInfo")
    @ResponseBody
    public Response showCustomerInfo(HttpServletRequest request){
        String userId = request.getParameter("id");
        Response response=new Response();
        CustomerInfo customerInfo=this.customerInfoService.selectByPrimaryKey(userId);
        response.setData(customerInfo);
        return response;
    }

    @RequestMapping("/addCustomerInfo")
    @ResponseBody
    public Response addCustomerInfo(CustomerInfo customerInfo){
        Response response=new Response();
        this.customerInfoService.insert(customerInfo);
        return response;
    }

    @RequestMapping("/updateCustomerInfo")
    @ResponseBody
    public Response updateCustomerInfo(CustomerInfo customerInfo){
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

    @RequestMapping("/deleteCustomerInfo")
    @ResponseBody
    public Response deleteCustomerInfo(HttpServletRequest request){
        String userId = request.getParameter("id");
        Response response=new Response();
        this.customerInfoService.deleteByPrimaryKey(userId);
        return response;
    }




}
