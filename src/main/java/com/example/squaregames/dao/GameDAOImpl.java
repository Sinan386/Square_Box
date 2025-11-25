package com.example.squaregames.dao;

import com.example.squaregames.dto.GameDTO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GameDAOImpl implements GameDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/squaregame";
    private static final String USER = "root";
    private static final String PASSWORD = "fakepassword";
    private Connection conn;


    public GameDAOImpl() {


        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                System.out.println("Connected to MySQL!");
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


    private final Map<String, GameDTO> data = new HashMap<>();

    @Override
    public Collection<GameDTO> getAll() {
        return data.values();
    }

    @Override
    public GameDTO getById(String id) {
        return data.get(id);   // null si pas trouvé, ça va pour l’instant
    }

    @Override
    public void save(String id, int boardSize) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO `game` VALUES ('" + id + "'," + boardSize + ")");
        } catch (SQLException e) {
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
