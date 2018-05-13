package com.lxyw.service;

import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.util.PageBean;
import com.lxyw.util.Response;

import java.util.List;

public interface UserInfoService {

    int deleteByPrimaryKey(String id);

    Response insert(UserInfo record);

    //Response insertSelective(UserInfo record);

    UserInfoVo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int batchInsert( List<UserInfo> list);

    PageBean<UserInfoVo> getUserInfoPageInfo(UserInfo record, int startIndex, int limit);

    boolean isUniqueUserName(String userName);

    boolean validateLogIn(UserInfo record);

    Response modifyUserPassword(UserInfo record);


}
