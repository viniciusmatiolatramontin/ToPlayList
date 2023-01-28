package com.toplaylist.to_play_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toplaylist.to_play_list.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
    
}
