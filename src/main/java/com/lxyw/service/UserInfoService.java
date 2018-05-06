package com.lxyw.service;

import com.lxyw.entity.UserInfo;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;

import java.util.List;

public interface UserInfoService {

    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int batchInsert( List<UserInfo> list);

    PageBean<UserInfo> getUserInfoPageInfo(UserInfo record,int startIndex,int limit);

    boolean isUniqueUserName(String userName);

    boolean validateLogIn(UserInfo record);


}
