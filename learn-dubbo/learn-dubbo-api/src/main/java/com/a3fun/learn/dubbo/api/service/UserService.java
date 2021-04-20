package com.a3fun.learn.dubbo.api.service;


import com.a3fun.learn.dubbo.api.entity.User;

/**
 * @author haixiangchen
 */
public interface UserService {
    /**
     * 通过ID获取User
     * @param id
     * @return
     */
    User getUserById(long id);

}
