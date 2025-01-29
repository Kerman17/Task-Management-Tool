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
//@Entity
//@Table
public class Comment {

    @Id
    private Long id;
    private Long task_id;
    private String comment_text;
    private String commented_by;
    private Date commented_at;

}
