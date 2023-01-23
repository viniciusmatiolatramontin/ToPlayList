package com.toplaylist.to_play_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toplaylist.to_play_list.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    
}
