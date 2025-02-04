package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.ProjectDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProjectDaoImpl implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    public ProjectDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
