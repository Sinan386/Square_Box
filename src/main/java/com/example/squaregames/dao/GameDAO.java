package com.example.squaregames.dao;

import com.example.squaregames.dto.GameDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import java.util.Collection;

public interface GameRepository extends JpaRepository<GameDTO, String> {}

//    public Collection<GameDTO> getAll();
//
//    public GameDTO getById(String id);
//
//    public void save(String id, int boardSize);
//
//    public void update(String id);
//
//    public void delete(String id);
//}
