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
public class Project {

    @Id
    private Long id;
    private String name;
    private String description;
    private String created_by;
    private Date created_at;

}
