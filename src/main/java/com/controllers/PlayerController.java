package com.controllers;

import com.models.Player;
import com.models.SnakeNLadderBoard;
import com.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/player", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player)
    {
        Player player1 = playerService.createNewPlayer(player);

        return new ResponseEntity(player1,  HttpStatus.OK);
    }
}
