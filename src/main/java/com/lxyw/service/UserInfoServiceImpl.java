package com.lxyw.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.lxyw.dao.UserInfoMapper;
import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.util.DateUtil;
import com.lxyw.util.PageBean;
import com.lxyw.util.PrimaryKeyGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        String primaryKey=PrimaryKeyGenerator.getPrimaryKey();
        record.setId(primaryKey);
        record.setPassword("123456");
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        String primaryKey=PrimaryKeyGenerator.getPrimaryKey();
        record.setId(primaryKey);
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<UserInfo> list) {
        return userInfoMapper.batchInsert(list);
    }

    @Override
    public PageBean<UserInfoVo> getUserInfoPageInfo(UserInfo record,int startIndex,int limit) {
        PageBean<UserInfoVo> userPageInfo=new PageBean<UserInfoVo>();
        List<UserInfo> userInfoList=userInfoMapper.selectUserInfoPageByCondition(record, startIndex, limit);
        int userInfoCount=userInfoMapper.selectUserInfoCountByCondition(record);
        List<UserInfoVo> userInfoVoList=new ArrayList<UserInfoVo>();
        for (UserInfo user:userInfoList){
            UserInfoVo userInfoVo=new UserInfoVo();
            BeanUtils.copyProperties(user,userInfoVo);
            userInfoVo.setBirthdayStr(DateUtil.DateFormat_YMD(user.getBirthday()));
            userInfoVo.setCreatedDateStr(DateUtil.DateFormat_YMD_HMS(user.getCreatedDate()));
            userInfoVo.setUpdateDateStr(DateUtil.DateFormat_YMD_HMS(user.getUpdateDate()));
            userInfoVoList.add(userInfoVo);
        }
        userPageInfo.setList(userInfoVoList);
        userPageInfo.setTotalSize(userInfoCount);
        //
        return userPageInfo;
    }

    @Override
    public boolean isUniqueUserName(String userName){
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername(userName);
        boolean isUnique=false;
        List<UserInfo> userInfoList= userInfoMapper.selectUserInfoListByCondition(userInfo);
       if(userInfoList==null||userInfoList.size()==0){
           isUnique=true;
       }
       return isUnique;
    }

    @Override
    public boolean validateLogIn(UserInfo record) {
        boolean logInSuccess=true;
        List<UserInfo> userInfoList= userInfoMapper.selectUserInfoListByCondition(record);
        if(userInfoList==null||userInfoList.size()==0){
            logInSuccess=false;
        }
        userInfoMapper.selectUserInfoListByCondition(record);
        return logInSuccess;
    }
}
