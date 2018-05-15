package com.lxyw.entityVo;

import com.lxyw.entity.CustomerInfo;
import com.lxyw.entity.CustomerLinks;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CustomerInfoAndLinksVo extends CustomerInfo {
    @Getter@Setter
    List<CustomerLinks> customerLinks=new ArrayList<>();

}
