package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Table
@Entity(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_seq")
    @SequenceGenerator(name = "notofication_id_seq", sequenceName = "notification_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private Date created_at;

    public Notification() {
    }

    public Notification(Long user_id, String message, String status, Date created_at) {
        this.user_id = user_id;
        this.message = message;
        this.status = status;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
