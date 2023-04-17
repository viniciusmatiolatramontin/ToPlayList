package com.toplaylist.to_play_list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toplaylist.to_play_list.model.Publisher;
import com.toplaylist.to_play_list.repository.PublisherRepository;
import com.toplaylist.to_play_list.exceptions.AccessDeniedException;
import com.toplaylist.to_play_list.exceptions.PublisherNotFoundException;
import com.toplaylist.to_play_list.model.CustomUserDetails;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getPublishers(CustomUserDetails user){
        List<Publisher> publishers = publisherRepository.findAll();

        for(int i = 0; i < publishers.size(); i++){
            if(!publishers.get(i).getUsername().equals(user.getUsername())){
                publishers.remove(i);
            }
        }

        return publishers;
    }

    public Publisher getPublisherById(CustomUserDetails user, Long id) throws AccessDeniedException {

        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException("Publisher not found!"));

        if(!publisher.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Publisher");
        }

        return publisher;
    }

    public Publisher savePublisher(CustomUserDetails user, Publisher publisher){
        publisher.setUsername(user.getUsername());
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(CustomUserDetails user, Publisher publisherUpdated, Long id) throws AccessDeniedException {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException("Publisher not found!"));

        if(!publisher.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Publisher");
        }

        publisher.setName(publisherUpdated.getName());

        return publisherRepository.save(publisher);
    }

    public Publisher deletePublisher(CustomUserDetails user, Long id) throws AccessDeniedException {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new PublisherNotFoundException("Publisher not found!"));

        if(!publisher.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Publisher");
        }

        publisherRepository.delete(publisher);

        return publisher;
    }
}
