package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Long task_id;

    @Column(nullable = false)
    private String comment_text;

    @Column(nullable = false)
    private String commented_by;

    @Column(nullable = false)
    @CreationTimestamp
    private Date commented_at;


    public Comment() {
    }

    public Comment(Long task_id, String comment_text, String commented_by, Date commented_at) {
        this.task_id = task_id;
        this.comment_text = comment_text;
        this.commented_by = commented_by;
        this.commented_at = commented_at;
    }

    public Comment(Long id, Long task_id, String comment_text, String commented_by, Date commented_at) {
        this.id = id;
        this.task_id = task_id;
        this.comment_text = comment_text;
        this.commented_by = commented_by;
        this.commented_at = commented_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getCommented_by() {
        return commented_by;
    }

    public void setCommented_by(String commented_by) {
        this.commented_by = commented_by;
    }

    public Date getCommented_at() {
        return commented_at;
    }

    public void setCommented_at(Date commented_at) {
        this.commented_at = commented_at;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", task_id=" + task_id +
                ", comment_text='" + comment_text + '\'' +
                ", commented_by='" + commented_by + '\'' +
                ", commented_at=" + commented_at +
                '}';
    }
}
