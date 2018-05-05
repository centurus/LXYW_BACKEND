package com.lxyw.controller;

import com.lxyw.entity.UserInfo;
import com.lxyw.service.UserInfoService;
import com.lxyw.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/userInfo")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/showUserInfo")
    @ResponseBody
    public Response showUser(HttpServletRequest request){
        String userId = request.getParameter("id");
        Response response=new Response();
        UserInfo user=this.userInfoService.selectByPrimaryKey(userId);
        response.setData(user);
        return response;
    }

    @RequestMapping("/addUserInfo")
    @ResponseBody
    public Response addUser(UserInfo userInfo){
        Response response=new Response();
        this.userInfoService.insert(userInfo);
        return response;
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Response updateUserInfo(UserInfo userInfo){
        Response response=new Response();
        this.userInfoService.updateByPrimaryKey(userInfo);
        return response;
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public Response updateUserInfo(HttpServletRequest request){
        Response response=new Response();
        String userId = request.getParameter("id");
        this.userInfoService.deleteByPrimaryKey(userId);
        return response;
    }


}
