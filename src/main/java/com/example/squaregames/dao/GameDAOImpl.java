package com.example.squaregames.dao;

import com.example.squaregames.dto.GameDTO;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Service
public class GameDAOImpl implements GameDAO {

    private final DataSource dataSource;


    private Connection conn;


    public GameDAOImpl(DataSource dataSource) {
        try {
            conn = dataSource.getConnection();

            if (conn != null) {
                System.out.println("Connected to MySQL!");
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        this.dataSource = dataSource;
    }

    private final Map<String, GameDTO> data = new HashMap<>();

    @Override
    public Collection<GameDTO> getAll() {
        return data.values();
    }

    @Override
    public GameDTO getById(String id) {
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM game WHERE id = '" + id + "'");

            if (results.next()) {
                GameDTO gameDTO = new GameDTO();
                gameDTO.setId(results.getString("id"));
                gameDTO.setBoardSize(results.getInt("boardSize"));

                        return gameDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(String id, int boardSize) {
        System.out.println(">>> DAO.save appelé avec id=" + id + ", boardSize=" + boardSize);

        try {
            Statement statement = conn.createStatement();

            String sql = "INSERT INTO game (id, boardSize) VALUES ('" + id + "', " + boardSize + ")";
            System.out.println(">>> SQL = " + sql);

            int rows = statement.executeUpdate(sql);
            System.out.println(">>> INSERT OK, rows=" + rows);
        } catch (SQLException e) {
            System.out.println(">>> ERREUR SQL DANS save()");
            e.printStackTrace();
        }
    }



    @Override
        public void update (String id){

        }

        @Override
        public void delete (String id){


        }
    }
