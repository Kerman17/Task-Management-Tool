package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.NotificationDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import com.raul.Collaborative_Task_Management_Tool.repositories.NotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NotificationDaoImpl implements NotificationDao {

    private final NotificationRepository notificationRepository;

    public NotificationDaoImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public void deleteNotificationById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public void saveNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public void addNotificationToUser(Notification notification, Long userId) {

    }


}
