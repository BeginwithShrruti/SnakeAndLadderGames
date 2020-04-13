package com.controllers;

import com.fasterxml.jackson.databind.type.MapLikeType;
import com.models.Ladder;
import com.models.Snake;
import com.models.SnakeNLadderBoard;
import com.services.SnakeAndLadderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class SnakeNLadderControllerTest {

    @InjectMocks
    private SnakeNLadderController snakeNLadderController;

    @Mock
    private SnakeAndLadderService snakeAndLadderService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createGameTest() {

        SnakeNLadderBoard snakeNLadderBoard = new SnakeNLadderBoard(50);
        snakeNLadderBoard.setSize(100);
        snakeNLadderBoard.setName("Mike");

        List<Ladder> ladders = new ArrayList<>();

        Ladder ladder = new Ladder();
        ladder.setStartPosition(6);
        ladder.setEndPosition(12);
        ladders.add(ladder);

        Ladder ladder1 = new Ladder();
        ladder1.setStartPosition(30);
        ladder1.setEndPosition(50);
        ladders.add(ladder1);

        snakeNLadderBoard.setLadders(ladders);

        List<Snake> snakes = new ArrayList<>();
        Snake snake = new Snake();
        snake.setStartPosition(11);
        snake.setEndPosition(55);
        snakes.add(snake);

        Snake snake1 = new Snake();
        snake1.setStartPosition(45);
        snake1.setEndPosition(75);
        snakes.add(snake1);

        snakeNLadderBoard.setSnakes(snakes);

        when(snakeAndLadderService.createGame(snakeNLadderBoard)).thenReturn(snakeNLadderBoard);
        ResponseEntity<SnakeNLadderBoard> snakeNLadderBoardResponseEntity =  snakeNLadderController.createGame(snakeNLadderBoard);
        List<Snake> snakeList = snakeNLadderBoardResponseEntity.getBody().getSnakes();
        List<Ladder> ladderList = snakeNLadderBoardResponseEntity.getBody().getLadders();
        assertEquals(snakeNLadderBoardResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(snakeNLadderBoardResponseEntity.getBody().getSize(), 100);
        assertEquals(snakeNLadderBoardResponseEntity.getBody().getName(), "Mike");
        assertEquals(snakeList.size(), 2);
        assertEquals(ladderList.size(), 2);


    }

    @Test
    void getAllGames() {

        List<SnakeNLadderBoard> snakeNLadderList = new ArrayList<>();
        SnakeNLadderBoard snakeNLadderBoard = new SnakeNLadderBoard();
        when(snakeAndLadderService.getAllGames()).thenReturn(snakeNLadderList);
        ResponseEntity<SnakeNLadderBoard> snakeNLadderBoardResponseEntity =
                snakeNLadderController.getAllGames();
        assertEquals(snakeNLadderBoardResponseEntity.getStatusCode(), HttpStatus.OK);
    }
}