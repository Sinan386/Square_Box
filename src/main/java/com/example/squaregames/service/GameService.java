package com.example.squaregames.service;

import com.example.squaregames.dto.GameCreationParams;


public interface GameService {

    String createGame(GameCreationParams params);


    Object getGame(String gameId);


}
