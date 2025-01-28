package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class Notification {

    @Id
    private Long id;
    private Long user_id;
    private String message;
    private String status;
    private Date created_at;
}
