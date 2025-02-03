package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.NotificationRepository;
import com.raul.Collaborative_Task_Management_Tool.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    // ENDPOINTS FOR USER - NOTIFICATION RELATIONSHIP

    public void addNotificationToUser(Long notifId,
                                      Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " does not exist"));

        Notification notification = notificationRepository.findById(notifId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + notifId + " does not exist"));


        notification.setUser(user);

        notificationRepository.save(notification);

    }


    // ENDPOINTS FOR USER - NOTIFICATION RELATIONSHIP



    public List<Notification> getAllNotifications(){
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id){
        return notificationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Notification with id " + id + " does not exist"));
    }

    public void addNotification(Notification notification){
        notificationRepository.save(notification);
    }

    public void deleteNotificationById(Long id){

        notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification with id " + id + " does not exist"));

        notificationRepository.deleteById(id);
    }

    @Transactional
    public void updateNotification(Long id,
                                   Long user_id,
                                   String message,
                                   String status){

        Notification notification = notificationRepository.findById(id)
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
