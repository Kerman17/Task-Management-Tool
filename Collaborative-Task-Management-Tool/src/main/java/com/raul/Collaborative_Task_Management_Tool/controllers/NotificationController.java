package com.raul.Collaborative_Task_Management_Tool.controllers;

import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import com.raul.Collaborative_Task_Management_Tool.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

    @GetMapping(path = "{notificationId}")
    public Notification getNotificationById(@PathVariable Long notificationId){
        return notificationService.getNotificationById(notificationId);
    }

    @PostMapping
    public void addNotification(@RequestBody Notification notification){
        notificationService.addNotification(notification);
    }

    @DeleteMapping(path = "{notificationId}")
    public void deleteNotificationById(@PathVariable Long notificationId){

        notificationService.deleteNotificationById(notificationId);
    }

    @PutMapping(path = "{notificationId}")
    public void updateNotificationById(@PathVariable Long notificationId,
                                       @RequestParam(required = false) Long user_id,
                                       @RequestParam(required = false) String message,
                                       @RequestParam(required = false) String status){

        notificationService.updateNotification(notificationId, user_id, message, status);

    }
}
