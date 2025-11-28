package com.example.squaregames.service;

import com.example.squaregames.dao.jpa.GameModel;
import com.example.squaregames.dao.jpa.GameRepository;
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
    private List<GamePlugin> plugins;

    @Autowired
    private GameRepository gameRepository;

    // stockage des parties du moteur en mémoire
    private Map<String, Game> games = new HashMap<>();

    @Override
    public String createGame(GameCreationParams params) {

        // 1) chercher le bon plugin
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

        // 2) créer la partie dans le moteur
        Game engineGame = plugin.createGame(
                params.getPlayerCount(),
                params.getBoardSize()
        );

        // 3) générer un id
        String gameId = UUID.randomUUID().toString();
        games.put(gameId, engineGame);

        // 4) créer l’entité JPA et la sauvegarder
        GameModel entity = GameModel.from(gameId, params);
        gameRepository.save(entity);

        // 5) renvoyer l’id au client
        return gameId;
    }

    @Override
    public Game getGame(String gameId) {
        return null;
    }
}
