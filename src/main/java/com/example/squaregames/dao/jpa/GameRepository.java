package com.example.squaregames.dao.jpa;

import com.example.squaregames.dto.GameDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameRepository extends CrudRepository<GameModel, UUID> {}

