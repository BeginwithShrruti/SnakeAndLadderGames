package com.services;

import com.dtos.SnakeNLadderBoardDTO;
import com.models.Player;
import com.models.SnakeNLadderBoard;
import com.repository.SnakeNLadderBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class SnakeAndLadderServiceImpl implements SnakeAndLadderService {


    @Autowired
    private SnakeNLadderBoardRepository snakeNLadderBoardRepository;

    private SnakeNLadderBoard snakeNLadderBoard;
    private int numPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;
    private int numDices;
    private static final int DEFAULT_BOARD_SIZE = 100;
    private static final int DEFAULT_NUMBER_DICES = 1;

    public SnakeAndLadderServiceImpl(int boardSize) {
        this.snakeNLadderBoard = new SnakeNLadderBoard(boardSize);  //Optional Rule 2
        this.players = new LinkedList<>();
        this.numDices = SnakeAndLadderServiceImpl.DEFAULT_NUMBER_DICES;
    }

    public SnakeAndLadderServiceImpl() {
        this(SnakeAndLadderServiceImpl.DEFAULT_BOARD_SIZE);
    }

    public List<SnakeNLadderBoard> getAllGames()
    {
        System.out.println("getAllGames");
        List<SnakeNLadderBoardDTO> snakeNLadderBoardDTOS = (List<SnakeNLadderBoardDTO>) snakeNLadderBoardRepository.findAll();

        for(int i=0; i<snakeNLadderBoardDTOS.size(); i++)
        {
            System.out.println(snakeNLadderBoardDTOS.get(i).getId());
        }
        return null;
    }

    public SnakeNLadderBoard createGame(SnakeNLadderBoard snakeNLadderBoard)
    {
        SnakeNLadderBoardDTO snakeNLadderBoardDTO = saveGame(snakeNLadderBoard);
        if(snakeNLadderBoardDTO != null) {
            snakeNLadderBoard.setId(snakeNLadderBoardDTO.getId());
        }
        return snakeNLadderBoard;
    }

    private SnakeNLadderBoardDTO saveGame(SnakeNLadderBoard snakeNLadderBoard)
    {
        SnakeNLadderBoardDTO snakeNLadderBoardDTO = new SnakeNLadderBoardDTO();
        snakeNLadderBoardDTO.setSize(snakeNLadderBoard.getSize());
        snakeNLadderBoardDTO.setName(snakeNLadderBoard.getName());
        snakeNLadderBoardDTO = snakeNLadderBoardRepository.save(snakeNLadderBoardDTO);


        return snakeNLadderBoardDTO;
    }

}
