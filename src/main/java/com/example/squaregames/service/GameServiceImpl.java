package com.example.squaregames.service;

import com.example.squaregames.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final TicTacToeGameFactory ticTacToeFactory = new TicTacToeGameFactory();
    private final ConnectFourGameFactory connectFourFactory = new ConnectFourGameFactory();


    public GameServiceImpl() {
        System.out.println("TicTacToe id      = " + ticTacToeFactory.getGameFactoryId());
        System.out.println("ConnectFour id    = " + connectFourFactory.getGameFactoryId());
    }

    public String createGame(GameCreationParams params) {

        Game game;

        switch (params.getType()) {
            case "tictactoe":
                game = ticTacToeFactory.createGame(
                        params.getPlayerCount(),
                        params.getBoardSize()
                );
                break;

            case "connect4":  
                game = connectFourFactory.createGame(
                        params.getPlayerCount(),
                        params.getBoardSize()
                );
                break;

            default:
                throw new IllegalArgumentException("Unknown game type: " + params.getType());
        }

        return UUID.randomUUID().toString();
    }

    @Override
    public Object getGame(String gameId) {
        return null;
    }
}
