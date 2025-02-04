package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.CommentDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommentDaoImpl implements CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public CommentDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
