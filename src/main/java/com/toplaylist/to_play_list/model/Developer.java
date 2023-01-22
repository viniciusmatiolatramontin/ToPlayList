package com.toplaylist.to_play_list.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Developer implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Game> games;

    public Developer() {

    }

    public Developer(String name) {
        this.setName(name);
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
}
