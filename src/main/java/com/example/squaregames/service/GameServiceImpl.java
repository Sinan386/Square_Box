package com.example.squaregames.service;

import com.example.squaregames.dto.GameCreationParams;
import com.example.squaregames.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private List<GamePlugin> plugins; // Spring injecte tous les GamePlugin (@Component)

    private Map<String, Game> games = new HashMap<>(); // clé(id) -> valeur(objet)

    @Override
    public String createGame(GameCreationParams params) {
        // cherche un plugin
        GamePlugin plugin = null;
        for (GamePlugin p : plugins) {
            if (p.getId().equals(params.getType())) {
                plugin = p;
                break;
            }
        }

        if (plugin == null) {
            throw new IllegalArgumentException("Unknown game type: " + params.getType());
        }

        Game game = plugin.createGame(
                params.getPlayerCount(),
                params.getBoardSize()
        );


        String gameId = UUID.randomUUID().toString();
        games.put(gameId, game);

        return gameId;
    }

    @Override
    public Object getGame(String gameId) {
        return games.get(gameId);
    }
}
