package com.lxyw.service;

import com.lxyw.dao.UserMapper;
import com.lxyw.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserSerciceImpl implements  UserService {


    @Resource
    private UserMapper userMapper;


    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
