package com.controllers;

import com.models.SnakeNLadderBoard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnakeNLadderController {

    @RequestMapping(value = "/snake-ladder-board", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<SnakeNLadderBoard> createBoard(@RequestBody SnakeNLadderBoard snakeNLadderBoard)
    {

        return new ResponseEntity(snakeNLadderBoard,  HttpStatus.OK);
    }
}
