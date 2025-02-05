package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.dao.NotificationDao;
import com.raul.Collaborative_Task_Management_Tool.dao.UserDao;
import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationDao notificationDao;

    private final UserDao userDao;


    @Autowired
    public NotificationService(NotificationDao notificationDao, UserDao userDao) {
        this.notificationDao = notificationDao;
        this.userDao = userDao;
    }

    // ENDPOINTS FOR USER - NOTIFICATION RELATIONSHIP

    public void addNotificationToUser(Long notifId,
                                      Long userId){

        User user = userDao.findUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " does not exist"));

        Notification notification = notificationDao.getNotificationById(notifId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + notifId + " does not exist"));

        notification.setUser_id(user.getId());

        notification.setUser(user);

        notificationDao.saveNotification(notification);

    }


    // ENDPOINTS FOR USER - NOTIFICATION RELATIONSHIP



    public List<Notification> getAllNotifications(){
        return notificationDao.getAllNotifications();
    }

    public Notification getNotificationById(Long id){
        return notificationDao.getNotificationById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Notification with id " + id + " does not exist"));
    }

    public void addNotification(Notification notification){
        notificationDao.saveNotification(notification);
    }

    public void deleteNotificationById(Long id){

        notificationDao.getNotificationById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id " + id + " does not exist"));

        notificationDao.deleteNotificationById(id);
    }

    @Transactional
    public void updateNotification(Long id,
                                   Long user_id,
                                   String message,
                                   String status){

        Notification notification = notificationDao.getNotificationById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id " + id + " does not exist"));

        if(user_id!=null && user_id>0 &&
           message!=null && message.length()>0 &&
           status!=null && status.length()>0){
            notification.setUser_id(user_id);
            notification.setMessage(message);
            notification.setStatus(status);
        }

    }

}
