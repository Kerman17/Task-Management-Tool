package com.raul.Collaborative_Task_Management_Tool.dao;

import com.raul.Collaborative_Task_Management_Tool.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
     Optional<User> findUserById(Long id);
     List<User> getAllUsers();
     void saveUser(User user);

     void deleteUserById(Long id);

     void updateUser(Long userId,
                           String name,
                           String email,
                           String role);

     Optional<User> findUserByEmail(String email);


}
