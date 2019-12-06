package com.portal.service.impl;

import com.portal.entity.QuarkResult;
import com.portal.entity.User;
import com.portal.service.UserService;
import com.portal.utils.HttpClientUtils;
import com.portal.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author LHR
 * Create By 2017/8/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${api_getUserByToken}")
    private String api_getUserByToken;

    @Override
    public User getUserByApi(String token) {
        String s = HttpClientUtils.doGet(api_getUserByToken + token);
        QuarkResult quarkResult = JsonUtils.jsonToQuarkResult(s, User.class);
        User data = (User) quarkResult.getData();
        return data;
    }
}
