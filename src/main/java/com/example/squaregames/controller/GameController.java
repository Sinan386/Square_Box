package com.example.squaregames.controller;

import com.example.squaregames.dao.jpa.GameModel;
import com.example.squaregames.dao.jpa.GameRepository;
import com.example.squaregames.dto.GameCreationParams;
import com.example.squaregames.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public String createGame(@RequestHeader("X-UserId") String userId,
                             @RequestBody GameCreationParams params) {

        System.out.println("createGame pour l'utilisateur : " + userId);
        return gameService.createGame(params);   // id de la partie
    }

    @GetMapping("/games/{gameId}")
    public Game getGame(@RequestHeader("X-UserId") String userId,
                        @PathVariable String gameId) {

        System.out.printf("getGame(%s) pour user %s%n", gameId, userId);
        return gameService.getGame(gameId);
    }

    @Operation(
            summary = "Create a game",
            description = "Create a game choosing betwen Taquin, TicTacToe and Connect Four",
            tags = {"Game", "Creation"})
    @ApiResponses({
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
    })
    /**
     * Create the game requested by the user
     *
     * @param params needed to create the according game
     * @return an instance of a game
     */
    @PostMapping("/")
    public String createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }
}


