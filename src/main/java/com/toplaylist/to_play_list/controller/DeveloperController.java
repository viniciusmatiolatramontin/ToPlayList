package com.toplaylist.to_play_list.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toplaylist.to_play_list.model.CustomUserDetails;
import com.toplaylist.to_play_list.model.Developer;
import com.toplaylist.to_play_list.service.DeveloperService;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping
    public List<Developer> getDevelopers(@AuthenticationPrincipal CustomUserDetails user) {
        return service.getDevelopers(user);
    }

    @GetMapping("/{id}")
    public Developer getDeveloperById(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id) throws AccessDeniedException {
        return service.getDeveloperById(user, id);
    }

    @PostMapping
    public Developer saveDeveloper(@AuthenticationPrincipal CustomUserDetails user, @RequestBody Developer dev) {
        return service.saveDeveloper(user, dev);
    }

}
