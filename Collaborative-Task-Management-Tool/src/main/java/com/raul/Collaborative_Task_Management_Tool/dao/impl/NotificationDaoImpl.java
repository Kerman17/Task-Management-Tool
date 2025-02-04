package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.NotificationDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class NotificationDaoImpl implements NotificationDao {

    private final JdbcTemplate jdbcTemplate;

    public NotificationDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
