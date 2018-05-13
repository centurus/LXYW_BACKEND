package com.lxyw.service;

import com.lxyw.entity.CustomerInfo;
import com.lxyw.util.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerInfoServiceImplTest {

    @Autowired
    private CustomerInfoService customerInfoService;

    @Test
    public void deleteByPrimaryKey() {
        CustomerInfo ci=new CustomerInfo();
        PageBean<CustomerInfo> lists= customerInfoService.getCustomerInfoPageInfo(ci,0,10);
        System.out.print(lists);
    }

}