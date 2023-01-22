package com.toplaylist.to_play_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.toplaylist.to_play_list.model.UserAuth;
import com.toplaylist.to_play_list.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserAuth addUser(UserAuth user) {
        if(repository.findByUsername(user.getUsername()) != null){
            throw new IllegalArgumentException("User already exists!");
        }
        
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        user.setPassword(bcrypt.encode(user.getPassword()));
        return repository.save(user);
    }
}
