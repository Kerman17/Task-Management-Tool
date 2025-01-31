package com.raul.Collaborative_Task_Management_Tool.services;

import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

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
