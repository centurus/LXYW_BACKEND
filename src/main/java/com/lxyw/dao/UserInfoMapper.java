package com.lxyw.dao;

import com.lxyw.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    int batchInsert(@Param("list") java.util.List<UserInfo> list);

    List<UserInfo> selectUserInfoListByCondition(@Param("condition") UserInfo userInfo);

    int selectUserInfoCountByCondition(@Param("condition") UserInfo userInfo);
}