package com.raul.Collaborative_Task_Management_Tool.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table(name = "comments")
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String comment_text;

    @Column(nullable = false)
    private String commented_by;

    @Column(nullable = false)
    @CreationTimestamp
    private Date commented_at;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;


    public Comment() {
    }

    public Comment( String comment_text, String commented_by, Date commented_at) {

        this.comment_text = comment_text;
        this.commented_by = commented_by;
        this.commented_at = commented_at;
    }

    public Comment(Long id, String comment_text, String commented_by, Date commented_at) {
        this.id = id;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment_text='" + comment_text + '\'' +
                ", commented_by='" + commented_by + '\'' +
                ", commented_at=" + commented_at +
                '}';
    }
}
