package com.example.squaregames.dao;

import com.example.squaregames.dto.GameDTO;

import java.util.Collection;
import java.util.List;

public class GameDAOimpl implements GameDAO {


    @Override
    public Collection<GameDTO> getAll() {
        return List.of();
    }

    @Override
    public GameDTO getById(String id) {
        return null;
    }

    @Override
    public void save(String id) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }
}