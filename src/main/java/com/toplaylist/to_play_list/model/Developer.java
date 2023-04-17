package com.toplaylist.to_play_list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Developer implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Name is empty")
    private String name;

    @OneToMany(mappedBy = "dev")
    @JsonIgnore
    private List<Game> games;

    @NotEmpty(message = "Username is empty")
    private String username;
    
    public Developer() {

    }

    public Developer(String name) {
        this.setName(name);
        games = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public String getUsername() {
        return username;
    }

    public void addGames(Game game) {
        games.add(game);
    }

    public void setUsername(String username) {
        this.username = username;
    }  

    
}
