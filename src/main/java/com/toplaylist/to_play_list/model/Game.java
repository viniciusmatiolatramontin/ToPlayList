package com.toplaylist.to_play_list.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer dev;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Status status;

    public Game() {

    }

    public Game(String name, Developer dev, Publisher publisher, Status status) {
        this.setName(name);
        this.setDev(dev);
        this.setPublisher(publisher);
        this.setStatus(status);
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

    public Developer getDev() {
        return dev;
    }

    public void setDev(Developer dev) {
        if(dev.equals(null)){
            throw new IllegalArgumentException("Developer field cannot be null");
        }

        this.dev = dev;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        if(publisher.equals(null)){
            throw new IllegalArgumentException("Publisher field cannot be null");
        }

        this.publisher = publisher;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if(status.equals(null)){
            throw new IllegalArgumentException("Status field cannot be null");
        }

        this.status = status;
    }

    
}
