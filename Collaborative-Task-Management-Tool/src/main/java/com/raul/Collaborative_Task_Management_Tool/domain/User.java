package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password_hash;
    private String role;
    private Date created_at;

}
