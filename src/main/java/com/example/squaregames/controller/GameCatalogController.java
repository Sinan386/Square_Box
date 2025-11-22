package com.example.squaregames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.squaregames.catalog.GameCatalog;

import java.util.Collection;


@RestController
public class GameCatalogController {

    @Autowired
    private GameCatalog gameCatalog;


    @GetMapping("/games")
    public Collection<String> listGames() {
        return gameCatalog.getGameIdentifiers();
    }

}
