package com.example.squaregames.dao.jpa;

import com.example.squaregames.dto.GameCreationParams;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class GameModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private int boardSize;

    private String gameType;

    public static GameModel from(GameCreationParams params) {
        GameModel gameModel = new GameModel();
        gameModel.setBoardSize(params.getBoardSize());
        gameModel.setGameType(params.getType());

        return  gameModel;
    }
}
