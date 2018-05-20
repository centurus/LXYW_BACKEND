package com.lxyw.controller;

import com.lxyw.entity.StockList;
import com.lxyw.entityVo.StockListVo;
import com.lxyw.service.StockListService;
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
@RequestMapping("/stockList")
public class StockListController {

    @Resource
    private StockListService stockListService;

    @RequestMapping(value="/getStockListPageInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getStockListPageInfo(@RequestBody StockListVo stockListVo) {
        Response response = new Response();
        StockList stockList = new StockList();
        stockList.setStockProductName(stockListVo.getStockProductName()==null?"":stockListVo.getStockProductName().trim());
        stockList.setStockProductStatus(stockListVo.getStockProductStatus());
        stockList.setStartDate(stockListVo.getStartDate()==null?"":stockListVo.getStartDate()+" 00:00:00");
        stockList.setEndDate(stockListVo.getEndDate()==null?"":stockListVo.getEndDate()+" 00:00:00");
        PageBean<StockList> stockListPageInfos = stockListService.getStoclistPageInfo(stockList, stockListVo.getPageIndex(), stockListVo.getPageSize());
        response.setData(stockListPageInfos);
        return response;
    }

    /**
     *
     * @param stockList
     * @return
     */
    @RequestMapping(value="/addStockList", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addStockList(@RequestBody StockList stockList){
        Response response=new Response();
        //供应商姓名和供应商字表内容不能为空
        if(stockList==null||StringUtils.isEmpty(stockList.getStockProductName())||
                stockList.getStockListFeeList()==null||stockList.getStockListFeeList().isEmpty()){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.stockListService.insertSelective(stockList);
        }
        return response;
    }


    /**
     * 库存信息修改
     * @param stockList
     * @return
     */
    @RequestMapping(value="/updateStockList", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateStockList(@RequestBody StockList stockList){
        Response response=new Response();
        if(stockList==null||StringUtils.isEmpty(stockList.getId())||
        stockList.getStockListFeeList()==null||stockList.getStockListFeeList().isEmpty()){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.stockListService.updateByPrimaryKeySelective(stockList);
        }
        return  response;
    }
    /**
     * 库存删除
     * @param stockList
     * @return
     */
    @RequestMapping(value="/deleteStockList", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response deleteStockList(@RequestBody StockList stockList){
        Response response=new Response();
        if(stockList==null||StringUtils.isEmpty(stockList.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.stockListService.deleteByPrimaryKey(stockList.getId());
        }
        return response;
    }

    /**
     * 通过id查找供库存信息
     * @param stockList
     * @return
     */
    @RequestMapping(value="/getStockListById", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getStockListById(@RequestBody StockList stockList){
        Response response=new Response();
        if(stockList==null||StringUtils.isEmpty(stockList.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            StockList result=this.stockListService.selectAllStockInfoByPrimaryKey(stockList.getId());
            response.setData(result);
        }
        return response;
    }

}
