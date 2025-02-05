package com.raul.Collaborative_Task_Management_Tool.services;


import com.raul.Collaborative_Task_Management_Tool.dao.UserDao;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserById(Long id){
        return userDao.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public void addNewUser(User user){
        userDao.saveUser(user);
    }

    public void deleteUserById(Long id){
        userDao.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));

        userDao.deleteUserById(id);
    }

    @Transactional
    public void updateUser(Long userId,
                           String name,
                           String email,
                           String role){

        User user = userDao.findUserById(userId).orElseThrow(()
        -> new IllegalStateException("User with id: " + userId + " does not exist!"));

        if(name!=null && name.length()>0
        && email!=null && email.length()>0
        && role!=null && role.length()>0){

            user.setName(name);
            user.setEmail(email);
            user.setRole(role);
        }

        userDao.saveUser(user);

    }

}
