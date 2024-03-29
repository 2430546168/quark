package com.chat.service.impl;

import com.chat.service.ChatService;
import com.chat.service.RedisService;
import com.common.base.BaseServiceImpl;
import com.common.dao.UserDao;
import com.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author : ChinaLHR
 * @Date : Create in 21:22 2017/10/23
 * @Email : 13435500980@163.com
 */
@Service
public class ChatServiceImpl extends BaseServiceImpl<UserDao, User> implements ChatService {

    @Autowired
    private RedisService<User> redisService;

    @Value("${REDIS_USER_KEY}")
    private String REDIS_USER_KEY;


    @Override
    public User getUserByToken(String token) {
        User user = redisService.getString(REDIS_USER_KEY + token);
        return user;
    }

    @Override
    public boolean authUser(Integer id) {
        User user = repository.findOne(id);
        return user.getEnable() == 1;
    }


}
