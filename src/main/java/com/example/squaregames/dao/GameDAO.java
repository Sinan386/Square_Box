package com.example.squaregames.dao;

import com.example.squaregames.dto.GameDTO;

import java.util.Collection;

public interface GameDAO {

    public Collection<GameDTO> getAll();

    public GameDTO getById(String id);

    public void save(String id, int boardSize);

    public void update(String id);

    public void delete(String id);
}
