package com.toplaylist.to_play_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toplaylist.to_play_list.model.UserAuth;

public interface UserRepository extends JpaRepository<UserAuth, Long>{
    UserAuth findByUsername(String username);
}
