package com.example.squaregames;

import java.util.Collection;

public interface GameCatalog {
    Collection<String> getGameIdentifiers();

    String createGame(GameCreationParams params);

}

