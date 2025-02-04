package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.dao.impl.UserDaoImpl;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserDaoImplTests {

    @Mock // mock created and injected into UserDaoImpl
    private JdbcTemplate jdbcTemplate;

    @InjectMocks // before each test is run a new instance of the UserDaoImpl is created
    private UserDaoImpl underTest;

    @Test
    public void testThatCreateUserGeneratesCorrectSql(){

        User user = new User(
                1L,
                "Raul Dete",
                "raul@yahoo.com",
                "test",
                "Admin",
                new Date());

        underTest.create(user);


        verify(jdbcTemplate).update(
                eq("INSERT INTO users (id, name, email, password_hash, role, created_at) VALUES (?, ?, ?, ?, ?, ?)"),
                eq(1L),eq("Raul Dete"), eq("raul@yahoo.com"), eq("test"), eq("Admin")
        );

    }

}
