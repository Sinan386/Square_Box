package com.example.squaregames.dao.jpa;

import com.example.squaregames.dto.GameCreationParams;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game")   // nom EXACT de la table MySQL
public class GameModel {

    @Id
    @Column(name = "id")          // colonne "id" (varchar(255))
    private String id;

    @Column(name = "boardSize")   // colonne EXACTE en BDD
    private int boardSize;

    @Column(name = "gameType")    // colonne EXACTE en BDD
    private String gameType;

    public GameModel() {}

    // -------- getters / setters --------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    // -------- helper pour créer depuis les params --------
    public static GameModel from(String id, GameCreationParams params) {
        GameModel g = new GameModel();
        g.setId(id);
        g.setBoardSize(params.getBoardSize());
        g.setGameType(params.getType());
        return g;
    }
}
