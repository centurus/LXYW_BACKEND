package com.lxyw.controller;


import com.lxyw.entity.CustomerInfo;
import com.lxyw.entityVo.CustomerInfoVo;
import com.lxyw.service.CustomerInfoService;
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
        //配置返回对
        CustomerInfo customerInfoResult=this.customerInfoService.selectByPrimaryKey(customerInfo.getId());
        response.setData(customerInfoResult);
        return response;
    }

   /* *
     * 添加客户
     * @param customerInfo
     * @return
    @RequestMapping(value="/addCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addCustomerInfo(@RequestBody CustomerInfoAndLinksVo customerInfo){
        Response response=new Response();
        if(customerInfo==null|| StringUtils.isEmpty(customerInfo.getCustomerName())||StringUtils.isEmpty(customerInfo.getCustomerType())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.insertSelective(customerInfo);
        }
        return response;
    }*/

    @RequestMapping(value="/addCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        if(customerInfo==null|| StringUtils.isEmpty(customerInfo.getCustomerName())||StringUtils.isEmpty(customerInfo.getCustomerType())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.insertSelective(customerInfo);
        }
        return response;
    }

    /**
     * 通过主键更新客户信息
     * @param customerInfo
     * @return
     */
    @RequestMapping(value="/updateCustomerInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateCustomerInfo(@RequestBody CustomerInfo customerInfo){
        Response response=new Response();
        customerInfo.setUpdateDate(new Date());
        if(customerInfo.getCustomerLinks()==null|| StringUtils.isEmpty(customerInfo.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.customerInfoService.updateByPrimaryKeySelective(customerInfo);
        }
        return response;
    }

    /**
     * 通过主键删除客户信息
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

    /**
     * 客户信息分页查询
     * @param customerInfoVo
     * @return
     */
    @RequestMapping(value="/getCustomerPageInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getCustomerPageInfo(@RequestBody CustomerInfoVo customerInfoVo){
        Response response=new Response();
        CustomerInfo customerInfo=new CustomerInfo();
        customerInfo.setCustomerCellphone(customerInfoVo.getCustomerCellphone());customerInfo.setCustomerName(customerInfoVo.getCustomerName());
        customerInfo.setCustomerType(customerInfoVo.getCustomerType());
        PageBean<CustomerInfo> customerInfoPageInfos=customerInfoService.getCustomerInfoPageInfo(customerInfo,customerInfoVo.getPageIndex(),customerInfoVo.getPageSize());
        response.setData(customerInfoPageInfos);
        return response;
    }



}
