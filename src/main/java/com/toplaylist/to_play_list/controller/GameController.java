package com.toplaylist.to_play_list.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toplaylist.to_play_list.model.CustomUserDetails;
import com.toplaylist.to_play_list.model.Game;
import com.toplaylist.to_play_list.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> getGames(@AuthenticationPrincipal CustomUserDetails user) {
        return service.getGames(user);
    }


    @GetMapping("/{id}")
    public Game getGameById(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id)
            throws AccessDeniedException {
        return service.getGameById(user, id);
    }


    @PostMapping("/dev/{devId}/publisher/{publisherId}")
    public Game saveGame(@AuthenticationPrincipal CustomUserDetails user, @RequestBody Game game,
            @PathVariable Long devId, @PathVariable Long publisherId) throws AccessDeniedException {
        return service.saveGame(user, game, devId, publisherId);
    }

    @PutMapping("/{id}/dev/{devId}/publisher/{publisherId}")
    public Game updateGame(@AuthenticationPrincipal CustomUserDetails user, @RequestBody Game updatedGame,
            @PathVariable Long id,
            @PathVariable Long devId, @PathVariable Long publisherId) throws AccessDeniedException {

        return service.updateGame(user, updatedGame, id, devId, publisherId);
    }

    @DeleteMapping("/{id}")
    public Game deleteGame(@AuthenticationPrincipal CustomUserDetails user, @PathVariable Long id)
            throws AccessDeniedException {
        return service.deleteGame(user, id);
    }

}
