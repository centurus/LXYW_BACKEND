package com.lxyw.controller;

import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.service.UserInfoService;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;
import com.lxyw.util.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/userInfo")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/addUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addUser(@RequestBody UserInfo userInfo){
        Response response=new Response();
        userInfo.setCreatedDate(new Date());
        this.userInfoService.insert(userInfo);
        return response;
    }

    /**
     * 根据id和属性更新用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/updateUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateUserInfo(@RequestBody UserInfo userInfo){
        Response response=new Response();
        userInfo.setUpdateDate(new Date());
        if(userInfo==null||StringUtils.isEmpty(userInfo.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.userInfoService.updateByPrimaryKeySelective(userInfo);
        }
        return response;
    }

    /**
     * 根据ID删除用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/deleteUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response deleteUserInfo(@RequestBody UserInfo userInfo){
        Response response=new Response();
        if(userInfo==null||StringUtils.isEmpty(userInfo.getId())){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }else{
            this.userInfoService.deleteByPrimaryKey(userInfo.getId());
        }
        return response;
    }

    /**
     * 获取分页信息
     * @param userInfoVo
     * @return
     */
    @RequestMapping(value="/getUserInfoPageInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getUserInfoPageInfo(@RequestBody UserInfoVo userInfoVo){
        Response response=new Response();
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(userInfoVo.getUsername());userInfo.setName(userInfoVo.getName());userInfo.setCellphone(userInfoVo.getCellphone());
        PageBean<UserInfoVo> userInfoPageInfo= this.userInfoService.getUserInfoPageInfo(userInfo,userInfoVo.getPageIndex(),userInfoVo.getPageSize());
        response.setData(userInfoPageInfo);
        return response;
    }

    /**
     * 用户名称是否为一
     * @param userName
     * @return
     */
    @RequestMapping(value="/isUniqueUserName", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response isUniqueUserName( @RequestParam(value = "userName", required = true)String userName){
        Response response=new Response();
        boolean isUnique= this.userInfoService.isUniqueUserName(userName);
        if(!isUnique){
            response.setCode(ResponseCode.NOT_UNIQUE_USER.getCode());
            response.setMessage(ResponseCode.NOT_UNIQUE_USER.getMessage());
        }
        return response;
    }

    /**
     * 验证用户名密码是否匹配
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/validateLogin", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response validateLogin(UserInfo userInfo){
        Response response=new Response();
        boolean successLogIn= this.userInfoService.validateLogIn(userInfo);
        if(!successLogIn){
           response.setCode(ResponseCode.ERROR_PASSWORD.getCode());
           response.setMessage(ResponseCode.ERROR_PASSWORD.getMessage());
        }
        return response;
    }

    /**
     * 根据ID查询用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/findUserByPrimaryKey", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response findUserByPrimaryKey(@RequestBody UserInfo userInfo){
        Response response=new Response();
        UserInfoVo user = this.userInfoService.selectByPrimaryKey(userInfo.getId());
        response.setData(user);
        return response;
    }

    /**
     * 修改用户密码
     * @param userInfo
     * @return 修改结果
     */
    @RequestMapping(value="/modifyUserPassword", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response modifyUserPassword(@RequestBody UserInfoVo userInfo){
        Response response=userInfoService.modifyUserPassword(userInfo);
        return response;
    }


    /**
     * 重置用户密码
     * @param userInfo
     * @return 重置密码结果
     */
    @RequestMapping(value="/resetUserPassword", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response resetUserPassword(@RequestBody UserInfoVo userInfo){
        Response response=userInfoService.modifyUserPassword(userInfo);
        return response;
    }



}
