package com.example.squaregames.catalog;

import com.example.squaregames.catalog.GameCatalog;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {

    private final TicTacToeGameFactory ticTacToeFactory = new TicTacToeGameFactory();
    private final ConnectFourGameFactory connectFourFactory = new ConnectFourGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of(
                ticTacToeFactory.getGameFactoryId(),
                connectFourFactory.getGameFactoryId()
        );
    }
}
