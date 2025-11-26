package com.example.squaregames.service;

import com.example.squaregames.dao.GameDAO;
import com.example.squaregames.dao.GameRepository;
import com.example.squaregames.dto.GameCreationParams;
import com.example.squaregames.dto.GameDTO;
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
    private List<GamePlugin> plugins;         // tous les plugins disponibles

    private Map<String, Game> games = new HashMap<>(); // id -> Game (moteur)

    @Autowired
    private GameRepository gameRespoitory;                 //  JPA

    @Override
    public String createGame(GameCreationParams params) {
        // 1) chercher le bon plugin en fonction de type
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

        GameDTO gameDTO = new GameDTO();
        entity.setId(gameId);
        entity.setName(params.getType());         // "tictactoe" / "connect4"
        entity.setPlayerCount(params.getPlayerCount());
        entity.setBoardSize(params.getBoardSize());

        gameRespoitory.save(entity); // Le JPA fait L'INSERT TOUT SEUL !

        return gameId;
    }

    @Override
    public Game getGame(String gameId) {

        GameDTO dto = gameDAO.getById(gameId.toString()); // Lecture en bdd via le DAO
        if (dto != null) {
            System.out.println("Depuis la BDD : id=" + dto.getId() + ", boardSize=" + dto.getBoardSize());
        } else {
            System.out.println("Aucun enregistrement en BDD pour id=" + gameId);
        }

        return games.get(gameId);
    }

    @Override
    public Game getById(UUID gameId) {
        return null;
    }


//    public Object getGame(String gameId) {
//        return games.get(gameId);
    }

