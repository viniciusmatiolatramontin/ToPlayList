package com.toplaylist.to_play_list.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    @NotNull(message = "developer_id is null")
    private Developer dev;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @NotNull(message = "publisher_id is null")
    private Publisher publisher;

    @NotEmpty(message = "Username is empty")
    private String username;

    @NotNull(message = "Status is null")
    private Status status;

    public Game() {

    }

    public Game(String name, Status status) {
        this.setName(name);
        this.setStatus(status);
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

    public Developer getDev() {
        return dev;
    }

    public void setDev(Developer dev) {
        this.dev = dev;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
