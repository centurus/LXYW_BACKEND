package com.lxyw.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserSerciceImpl implements  UserService {


    @Resource
    private UserDao userDao;


    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
