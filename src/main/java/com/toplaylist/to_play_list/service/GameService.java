package com.toplaylist.to_play_list.service;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toplaylist.to_play_list.model.Game;
import com.toplaylist.to_play_list.repository.GameRepository;
import com.toplaylist.to_play_list.exceptions.GameNotFoundException;
import com.toplaylist.to_play_list.model.CustomUserDetails;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private DeveloperService devService;

    public List<Game> getGames(CustomUserDetails user){
        List<Game> games = gameRepository.findAll();

        for(int i = 0; i < games.size(); i++){
            if(!games.get(i).getUsername().equals(user.getUsername())){
                games.remove(i);
            }
        }

        return games;
    }

    public Game getGameById(CustomUserDetails user, Long id) throws AccessDeniedException {

        Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found!"));

        if(!game.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Game");
        }

        return game;
    }

    public Game saveGame(CustomUserDetails user, Game game, Long devId, Long publisherId) throws AccessDeniedException {
        game.setUsername(user.getUsername());
        game.setPublisher(publisherService.getPublisherById(user, publisherId));
        game.setDev(devService.getDeveloperById(user, devId));
        return gameRepository.save(game);
    }

    public Game updateGame(CustomUserDetails user, Game gameUpdated, Long id, Long devId, Long publisherId) throws AccessDeniedException {
        Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found!"));

        if(!game.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Game");
        }

        game.setName(gameUpdated.getName());
        game.setStatus(gameUpdated.getStatus());
        game.setPublisher(publisherService.getPublisherById(user, publisherId));
        game.setDev(devService.getDeveloperById(user, devId));

        return gameRepository.save(game);
    }

    public Game deleteGame(CustomUserDetails user, Long id) throws AccessDeniedException {
        Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game not found!"));

        if(!game.getUsername().equals(user.getUsername())){
            throw new AccessDeniedException("You don't have access to this Game");
        }

        gameRepository.delete(game);

        return game;
    }
}

