package com.example.squaregames.controller;

import com.example.squaregames.dto.GameDTO;
import com.example.squaregames.plugin.GamePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.squaregames.catalog.GameCatalog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


@RestController
public class GameCatalogController {

    @Autowired
    private List<GamePlugin> plugins;

    @GetMapping("/games")
    public List<GameDTO> listGames(Locale locale) {
        List<GameDTO> result = new ArrayList<>();

        for (GamePlugin plugin : plugins) {
            String id = plugin.getId();           // ex: "tictactoe" ou "connect4"
            String name = plugin.getName(locale); // ex: "Morpion" / "Puissance 4" en fr

            GameDTO info = new GameDTO(id, name);
            result.add(info);
        }

        return result;

    }

}
