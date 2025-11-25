package com.example.squaregames.dto;


public class GameDTO {

    private String id;
    private String type;
    private int playerCount;
    private int boardSize;


    public GameDTO() {}


    public GameDTO(String id, String type) {
        this.id = id;
        this.type = type;

    }

    public GameDTO(String id, String name, int playerCount, int boardSize) {
        this.id = id;
        this.type = type;
        this.playerCount = playerCount;
        this.boardSize = boardSize;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}


