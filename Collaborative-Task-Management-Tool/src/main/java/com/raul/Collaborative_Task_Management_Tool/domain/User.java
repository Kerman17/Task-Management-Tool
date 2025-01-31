package com.raul.Collaborative_Task_Management_Tool.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;


import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false)
    private String role;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date created_at;

    public User() {

    }

    public User(String name, String email, String password_hash, String role, Date created_at) {
        this.name = name;
        this.email = email;
        this.password_hash = password_hash;
        this.role = role;
        this.created_at = created_at;
    }

    public User(Long id, String name, String email, String password_hash, String role, Date created_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password_hash = password_hash;
        this.role = role;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", role='" + role + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
