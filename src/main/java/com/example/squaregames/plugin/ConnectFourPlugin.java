package com.example.squaregames.plugin;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ConnectFourPlugin implements GamePlugin {

    private final ConnectFourGameFactory factory = new ConnectFourGameFactory();

    @Value("${game.connect4.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.connect4.default-board-size}")
    private int defaultBoardSize;

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getId() {
        return factory.getGameFactoryId(); // "connect4"

    }

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.connect4.name", null, locale);
    }

    @Override
    public Game createGame(Integer playerCount, Integer boardSize) {
        int players = (playerCount != null) ? playerCount : defaultPlayerCount;
        int size = (boardSize != null) ? boardSize : defaultBoardSize;
        return factory.createGame(players, size);
    }
}
