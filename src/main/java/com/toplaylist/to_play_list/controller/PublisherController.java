package com.toplaylist.to_play_list.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toplaylist.to_play_list.model.CustomUserDetails;
import com.toplaylist.to_play_list.model.Publisher;
import com.toplaylist.to_play_list.service.PublisherService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService service;

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Publisher> getPublishers(@AuthenticationPrincipal CustomUserDetails user) {
        return service.getPublishers(user);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Publisher getPublisherById(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id) throws AccessDeniedException {
        return service.getPublisherById(user, id);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public Publisher savePublisher(@AuthenticationPrincipal CustomUserDetails user, @RequestBody Publisher publisher) {
        return service.savePublisher(user, publisher);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Publisher updatePublisher(@AuthenticationPrincipal CustomUserDetails user, @RequestBody Publisher updatedPublisher, @PathVariable Long id) throws AccessDeniedException {
        return service.updatePublisher(user, updatedPublisher, id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Publisher deletePublisher(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id) throws AccessDeniedException {
        return service.deletePublisher(user, id);
    }

}
