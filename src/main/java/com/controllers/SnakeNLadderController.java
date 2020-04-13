package com.controllers;

import com.models.SnakeNLadderBoard;
import com.services.SnakeAndLadderService;
import com.services.SnakeAndLadderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SnakeNLadderController {

   @Autowired
    private SnakeAndLadderService snakeNLadderService ;

    @RequestMapping(value = "/snake-ladder-board", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<SnakeNLadderBoard> createGame(@RequestBody SnakeNLadderBoard snakeNLadderBoard)
    {
        SnakeNLadderBoard snakeNLadderBoard1 = snakeNLadderService.createGame(snakeNLadderBoard);

        return new ResponseEntity(snakeNLadderBoard1,  HttpStatus.OK);
    }

    @RequestMapping(value = "/snake-ladder-board", method = RequestMethod.GET)
    public ResponseEntity<SnakeNLadderBoard> getAllGames()
    {
        System.out.println("getapicall");
        List<SnakeNLadderBoard> result = snakeNLadderService.getAllGames();
        return new ResponseEntity(result,  HttpStatus.OK);
    }

}
