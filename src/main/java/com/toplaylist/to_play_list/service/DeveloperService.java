package com.toplaylist.to_play_list.service;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toplaylist.to_play_list.model.Developer;
import com.toplaylist.to_play_list.repository.DeveloperRepository;
import com.toplaylist.to_play_list.exceptions.DeveloperNotFoundException;
import com.toplaylist.to_play_list.model.CustomUserDetails;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository devRepository;

    public List<Developer> getDevelopers(CustomUserDetails user){
        List<Developer> devs = devRepository.findAll();

        for(int i = 0; i < devs.size(); i++){
            if(!devs.get(i).getUsername().equals(user.getUsername())){
                devs.remove(i);
            }
        }

        return devs;
    }

    public Developer getDeveloperById(CustomUserDetails user, Long id) throws AccessDeniedException {

        Developer dev = devRepository.findById(id).orElseThrow(() -> new DeveloperNotFoundException("Developer not found!"));

        if(dev.getUsername().equals(user.getUsername())){
            return dev;
        } else {
            throw new AccessDeniedException("You don't have access to this developer");
        }
    }

    public Developer saveDeveloper(CustomUserDetails user, Developer dev){
        dev.setUsername(user.getUsername());
        return devRepository.save(dev);
    }
}
