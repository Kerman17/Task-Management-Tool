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
public class Task {

    @Id
    private Long id;
    private Long project_id;
    private String description;
    private String status;
    private String priority;
    private String assigned_to;
    private Date due_date;
    private Date created_at;

}
