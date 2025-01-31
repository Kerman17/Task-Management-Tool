package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Long project_id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String priority;

    @Column(nullable = false)
    private String assigned_to;

    private Date due_date;

    @CreationTimestamp
    @Column(nullable = false, name = "created_at")
    private Date created_at;

    public Task() {
    }

    public Task(Long project_id, String description, String status, String priority, String assigned_to, Date due_date, Date created_at) {
        this.project_id = project_id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assigned_to = assigned_to;
        this.due_date = due_date;
        this.created_at = created_at;
    }

    public Task(Long id, Long project_id, String description, String status, String priority, String assigned_to, Date due_date, Date created_at) {
        this.id = id;
        this.project_id = project_id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assigned_to = assigned_to;
        this.due_date = due_date;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", project_id=" + project_id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", assigned_to='" + assigned_to + '\'' +
                ", due_date=" + due_date +
                ", created_at=" + created_at +
                '}';
    }
}
