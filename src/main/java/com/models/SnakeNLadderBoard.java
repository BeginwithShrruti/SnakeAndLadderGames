package com.models;

import java.util.List;
import java.util.Map;

public class SnakeNLadderBoard {

  private int size;
  private List<Ladder> ladders;
  private List<Snake> snakes;
  private Map<Integer, Integer> playerPieces;
  private List<Integer> players;
  private String name;
  private long id;

    public long getId()
    {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPlayers() {
        return players;
    }

    public void setPlayers(List<Integer> players) {
        this.players = players;
    }

    public SnakeNLadderBoard(int size)
  {
      this.size = size;
  }

  public SnakeNLadderBoard()
  {

  }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<Integer, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
