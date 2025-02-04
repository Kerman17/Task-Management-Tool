package com.raul.Collaborative_Task_Management_Tool.services;


import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import com.raul.Collaborative_Task_Management_Tool.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(Long id){
        boolean exists = userRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException(
                    "User with id " + id + " does not exist"
            );
        }

        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long userId,
                           String name,
                           String email,
                           String role){

        User user = userRepository.findById(userId).orElseThrow(()
        -> new IllegalStateException("User with id: " + userId + " does not exist!"));

        if(name!=null && name.length()>0
        && email!=null && email.length()>0
        && role!=null && role.length()>0){

            user.setName(name);
            user.setEmail(email);
            user.setRole(role);
        }


    }

}
