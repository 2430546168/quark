package com.rest.service.impl;

import com.common.base.BaseServiceImpl;
import com.common.dao.NotificationDao;
import com.common.entity.Notification;
import com.common.entity.User;
import com.rest.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl extends BaseServiceImpl<NotificationDao, Notification> implements NotificationService {
    @Override
    public long getNotificationCount(int uid) {
        return repository.getNotificationCount(uid);
    }

    @Override
    public List<Notification> findByUser(User user) {
        List<Notification> byTouserOrderByInitTimeDesc = repository.getByTouserOrderByInitTimeDesc(user);
        repository.updateByIsRead(user);
        return byTouserOrderByInitTimeDesc;
    }

    @Override
    public void deleteByUser(User user) {
        List<Notification> byTouserOrderByInitTimeDesc = repository.getByTouserOrderByInitTimeDesc(user);
        repository.deleteInBatch(byTouserOrderByInitTimeDesc);
    }
}
