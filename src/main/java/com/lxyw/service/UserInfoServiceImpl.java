package com.lxyw.service;

import com.lxyw.dao.UserInfoMapper;
import com.lxyw.entity.UserInfo;
import com.lxyw.entityVo.UserInfoVo;
import com.lxyw.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private SendMailService sendMailService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增用户，用户名必须唯一
     * @param record
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Response insert(UserInfo record) {
        Response response=new Response();
        if(!this.isUniqueUserName(record.getUsername())){
            response.setCode(ResponseCode.NOT_UNIQUE_USER.getCode());
            response.setMessage(ResponseCode.NOT_UNIQUE_USER.getMessage());
        }
        String initPass="123456";
        String primaryKey=PrimaryKeyGenerator.getPrimaryKey();
        record.setId(primaryKey);
        String password="";
        try {
            password= MD5.encryption(initPass);
        } catch (LXYWException e) {
            logger.error(e.getMessage()+"userId={},password={}",record.getId(),record.getPassword());
        }
        record.setPassword(password);
        userInfoMapper.insert(record);
        sendMailService.sendMail();
        return response;
    }

    @Override
    public UserInfoVo selectByPrimaryKey(String id) {
        UserInfoVo userInfoVo=new UserInfoVo();
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(userInfo,userInfoVo);
        userInfoVo.setBirthdayStr(DateUtil.DateFormat_YMD(userInfo.getBirthday()));
        return userInfoVo;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
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

    /**
     * 获取用户分页信息
     * @param record
     * @param startIndex
     * @param limit
     * @return
     */
    @Override
    public PageBean<UserInfoVo> getUserInfoPageInfo(UserInfo record,int startIndex,int limit) {
        PageBean<UserInfoVo> userPageInfo=new PageBean<>();
        List<UserInfo> userInfoList=userInfoMapper.selectUserInfoPageByCondition(record, startIndex, limit);
        int userInfoCount=userInfoMapper.selectUserInfoCountByCondition(record);
        List<UserInfoVo> userInfoVoList=new ArrayList<>();
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
        return userPageInfo;
    }

    /**
     * 是否为唯一用户
     * @param userName
     * @return
     */
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

    /**
     * 登录
     * @param record
     * @return
     */
    @Override
    public boolean validateLogIn(UserInfo record) {
        boolean logInSuccess=true;
        String password="'";
        try {
             password=MD5.encryption(record.getPassword());
        } catch (LXYWException e) {
            logger.error(e.getMessage()+"userId={},password={}",record.getId(),record.getPassword());
        }
        record.setPassword(password);
        List<UserInfo> userInfoList= userInfoMapper.selectUserInfoListByCondition(record);
        if(userInfoList==null||userInfoList.size()==0){
            logInSuccess=false;
        }
        return logInSuccess;
    }

    /**
     * 修改用户密码
     * @param record
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public Response modifyUserPassword(UserInfo record) {
        Response response=new Response();
        if(record.getId()==null||record.getPassword()==null){
            response.setCode(ResponseCode.INVALID_PAREMETER.getCode());
            response.setMessage(ResponseCode.INVALID_PAREMETER.getMessage());
        }
        String password="'";
        try {
            password=MD5.encryption(record.getPassword());
        } catch (LXYWException e) {
            logger.error(e.getMessage()+"userId={},password={}",record.getId(),record.getPassword());
        }
        record.setPassword(password);
        userInfoMapper.updateByPrimaryKeySelective(record);
        return response;
    }
}
