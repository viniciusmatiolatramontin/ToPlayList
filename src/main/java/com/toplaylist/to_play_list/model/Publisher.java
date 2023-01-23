package com.toplaylist.to_play_list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @OneToMany
    private List<Game> games;

    private String username;

    public Publisher() {

    }

    public Publisher(String name) {
        this.setName(name);

        games = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id.equals(null) || id < 0){
            throw new IllegalArgumentException("Id field cannot be null and cannot be less than 0");
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals(null)){
            throw new IllegalArgumentException("Name field cannot be null");
        }

        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public String getUsername() {
        return username;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
