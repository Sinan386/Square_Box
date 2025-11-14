package com.example.squaregames;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class GameCatalogImpl implements GameCatalog {

    private final TicTacToeGameFactory ticTacToeFactory = new TicTacToeGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {

        return List.of(ticTacToeFactory.getGameFactoryId());
    }
}
