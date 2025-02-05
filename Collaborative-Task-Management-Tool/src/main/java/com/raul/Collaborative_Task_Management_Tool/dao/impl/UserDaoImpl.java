package com.raul.Collaborative_Task_Management_Tool.dao.impl;

import com.raul.Collaborative_Task_Management_Tool.dao.UserDao;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;


    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long userId, String name, String email, String role) {

    }
}
