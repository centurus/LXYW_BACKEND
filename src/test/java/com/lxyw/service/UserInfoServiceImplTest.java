package com.lxyw.service;

import com.lxyw.entity.UserInfo;
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
        userInfo.setId("ab42d16a1a4745debda152052f4c5e81");
        userInfo.setPassword("2789");
        userInfoService.modifyUserPassword(userInfo);
    }
}