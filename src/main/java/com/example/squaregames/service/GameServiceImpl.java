package com.example.squaregames.service;

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
    private List<GamePlugin> plugins;     // tous les plugins disponibles

    // stockage en mémoire des parties du moteur
    private Map<String, Game> games = new HashMap<>();
}

    //@Autowired
    //private GameRepository gameRepository;   // Repository JPA

//    @Override
//    public String createGame(GameCreationParams params) {
//        // 1) chercher le bon plugin en fonction de type
//        GamePlugin plugin = null;
//        for (GamePlugin p : plugins) {
//            if (p.getId().equals(params.getType())) {
//                plugin = p;
//                break;
//            }
//        }
//
//        if (plugin == null) {
//            throw new IllegalArgumentException("Unknown game type: " + params.getType());
//        }
//
//        // 2) créer la partie avec le moteur
//        Game game = plugin.createGame(
//                params.getPlayerCount(),
//                params.getBoardSize()
//        );
//
//        // 3) générer un id
//        String gameId = UUID.randomUUID().toString();
//        games.put(gameId, game);
//
//        // 4) construire l'entité JPA et la sauvegarder en BDD
//        GameDTO entity = new GameDTO();
//        entity.setId(gameId);
//        entity.setName(params.getType());           // "tictactoe" / "connect4"
//        entity.setPlayerCount(params.getPlayerCount());
//        entity.setBoardSize(params.getBoardSize());
//
//        gameRepository.save(entity);  // JPA fait l'INSERT tout seul
//
//        // 5) retourner l'id
//        return gameId;
//    }

//    @Override
//    public Game getGame(String gameId) {
//
////        // (optionnel) lire en BDD pour debug
////        gameRepository.findById(gameId).ifPresent(dto -> {
////            System.out.println("Depuis JPA : id=" + dto.getId()
////                    + ", type=" + dto.getName()
////                    + ", boardSize=" + dto.getBoardSize());
////        });
////
////        // retourner la partie du moteur
////        return games.get(gameId);
//        return null;
//    }

//    @Override
//    public Game getById(UUID gameId) {
//        return null;
//    }
//}
