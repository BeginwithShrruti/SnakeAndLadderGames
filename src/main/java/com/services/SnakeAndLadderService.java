package com.services;

import com.models.SnakeNLadderBoard;

import java.util.List;

public interface SnakeAndLadderService {

 public List<SnakeNLadderBoard> getAllGames();
 public SnakeNLadderBoard createGame(SnakeNLadderBoard snakeNLadderBoard);

}
