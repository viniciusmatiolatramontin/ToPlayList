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

@Entity
public class Publisher implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
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

    public void addGame(Game game) {
        games.add(game);
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
