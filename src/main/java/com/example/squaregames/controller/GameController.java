package com.example.squaregames.controller;

import com.example.squaregames.dto.GameCreationParams;
import com.example.squaregames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {

        return gameService.createGame(params);
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {
        System.out.printf("getGame(%s)%n", gameId);
        return gameService.getGame(gameId);
    }

}

