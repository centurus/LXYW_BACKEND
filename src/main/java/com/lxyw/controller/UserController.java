package com.lxyw.controller;

import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.service.UserInfoService;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;
import com.lxyw.util.ResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/userInfo")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value="/showUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response showUser(HttpServletRequest request){
        String userId = request.getParameter("id");
        Response response=new Response();
        UserInfo user=this.userInfoService.selectByPrimaryKey(userId);
        response.setData(user);
        return response;
    }

    @RequestMapping(value="/addUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response addUser(UserInfo userInfo){
        Response response=new Response();
        this.userInfoService.insert(userInfo);
        return response;
    }

    @RequestMapping(value="/updateUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response updateUserInfo(UserInfo userInfo){
        Response response=new Response();
        this.userInfoService.updateByPrimaryKey(userInfo);
        return response;
    }

    @RequestMapping(value="/deleteUserInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response deleteUserInfo(HttpServletRequest request){
        Response response=new Response();
        String userId = request.getParameter("id");
        this.userInfoService.deleteByPrimaryKey(userId);
        return response;
    }

    /**
     * 获取分页信息
     * @param request
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getUserInfoPageInfo", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response getUserInfoPageInfo(HttpServletRequest request,
                                        @RequestParam(value = "pageIndex", required = false)Integer pageIndex,
                                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                        @RequestParam(value = "username", required = false) String username,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "cellphoneNo", required = false) String cellphoneNo){
        Response response=new Response();
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(username);userInfo.setName(name);userInfo.setCellphoneNo(cellphoneNo);
        PageBean<UserInfoVo> userInfoPageInfo= this.userInfoService.getUserInfoPageInfo(userInfo,pageIndex,pageSize);
        response.setData(userInfoPageInfo);
        return response;
    }

    /**
     * 用户名称是否为一
     * @param request
     * @param userName
     * @return
     */
    @RequestMapping(value="/isUniqueUserName", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response isUniqueUserName(HttpServletRequest request, @RequestParam(value = "userName", required = true)String userName){
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
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/validateLogin", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response validateLogin(HttpServletRequest request,UserInfo userInfo){
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
     * @param request
     * @param userInfo
     * @return
     */
    @RequestMapping(value="/findUserByPrimaryKey", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public Response findUserByPrimaryKey(HttpServletRequest request,UserInfo userInfo){
        Response response=new Response();
        UserInfo user = this.userInfoService.selectByPrimaryKey(userInfo.getId());
        if(null != user){
            response.setCode(ResponseCode.SUCCESS.getCode());
            response.setMessage(ResponseCode.SUCCESS.getMessage());
            response.setData(user);
        }else{
           //TODO 错误信息待规划
        }
        return response;
    }


}
