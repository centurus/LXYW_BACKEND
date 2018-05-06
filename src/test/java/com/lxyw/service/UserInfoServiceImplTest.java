package com.lxyw.service;

import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.util.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void isUniqueUserName() {
        UserInfo userInfo=new UserInfo();
        userInfo.setName("");userInfo.setUsername("");
        userInfo.setCellphoneNo("");
        PageBean<UserInfoVo> userInfoList=userInfoService.getUserInfoPageInfo(userInfo,0,20);
        System.out.print(userInfoList);
    }
}