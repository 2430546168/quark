package com.portal.service;


import com.portal.entity.User;

/**
 * @Author LHR
 * Create By 2017/8/24
 */
public interface UserService {

    User getUserByApi(String token);


}
