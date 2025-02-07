package com.raul.Collaborative_Task_Management_Tool.services;


import com.raul.Collaborative_Task_Management_Tool.dao.UserDao;
import com.raul.Collaborative_Task_Management_Tool.domain.User;
import com.raul.Collaborative_Task_Management_Tool.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDao.findUserByEmail(username);
        if(user.isPresent()){

            var userObj = user.get();
            return (UserDetails) User.builder()
                    .name(userObj.getName())
                    .password_hash(userObj.getPassword_hash())
                    .role(userObj.getRole())
                    .email(userObj.getEmail())
                    .build();
        }else{
            throw new UsernameNotFoundException(username);
        }
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
