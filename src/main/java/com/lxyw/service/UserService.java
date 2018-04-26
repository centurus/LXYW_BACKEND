package com.lxyw.service;

import com.lxyw.entity.User;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}
