package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.domain.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationDao {
    List<Notification> getAllNotifications();
    Optional<Notification> getNotificationById(Long id);

    void deleteNotificationById(Long id);

    void saveNotification(Notification notification);

    void addNotificationToUser(Notification notification, Long userId);
}
