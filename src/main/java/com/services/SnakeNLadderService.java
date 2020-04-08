package com.services;

import com.models.Player;
import com.models.SnakeNLadderBoard;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeNLadderService {

    private SnakeNLadderBoard snakeNLadderBoard;
    private int numPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;
    private int numDices;
    private static final int DEFAULT_BOARD_SIZE = 100;
    private static final int DEFAULT_NUMBER_DICES = 1;

    public SnakeNLadderService(int boardSize) {
        this.snakeNLadderBoard = new SnakeNLadderBoard(boardSize);  //Optional Rule 2
        this.players = new LinkedList<>();
        this.numDices = SnakeNLadderService.DEFAULT_NUMBER_DICES;
    }

    public SnakeNLadderService() {
        this(SnakeNLadderService.DEFAULT_BOARD_SIZE);
    }
}
