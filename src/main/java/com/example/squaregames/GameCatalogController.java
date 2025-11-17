package com.example.squaregames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/games")
    public Collection<String> listGames()
    {
        return gameCatalog.getGameIdentifiers();
    }

    public String createGame(@RequestBody GameCreationParams params) {
        return gameCatalog.createGame(params);
    }

}
