package com.example.squaregames.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class GameDTO {

    @Id

    private String id;
    private String name;
    private int playerCount;
    private int boardSize;


    public GameDTO() {}


    public GameDTO(String id, String type) {
        this.id = id;
        this.name = type;

    }

    public GameDTO(String id, String name, int playerCount, int boardSize) {
        this.id = id;
        this.name = name;
        this.playerCount = playerCount;
        this.boardSize = boardSize;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public String toString() {
        return this.boardSize + " " + this.playerCount + " " + this.id;
    }
}


