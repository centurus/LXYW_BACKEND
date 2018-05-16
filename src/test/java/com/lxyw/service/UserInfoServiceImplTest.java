package com.lxyw.service;

import com.lxyw.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void isUniqueUserName() {
        UserInfo userInfo=new UserInfo();
        userInfo.setId("245a951a89a642459cccf51d01a4fc01");
        userInfo.setPassword("2789");
        userInfoService.modifyUserPassword(userInfo);
        logger.info("1111");

    }
}