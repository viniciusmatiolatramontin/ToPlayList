package com.toplaylist.to_play_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.toplaylist.to_play_list.model.CustomUserDetails;
import com.toplaylist.to_play_list.model.UserAuth;
import com.toplaylist.to_play_list.repository.UserRepository;


@Service()
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = repository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User Not found");
        }

        return new CustomUserDetails(user);
    }
    
}
