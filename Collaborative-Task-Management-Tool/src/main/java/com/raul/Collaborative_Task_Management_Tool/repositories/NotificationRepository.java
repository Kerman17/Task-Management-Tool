package com.raul.Collaborative_Task_Management_Tool.repositories;

import com.raul.Collaborative_Task_Management_Tool.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
