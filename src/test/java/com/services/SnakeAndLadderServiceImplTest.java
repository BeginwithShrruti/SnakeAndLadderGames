package com.services;

import com.dtos.SnakeNLadderBoardDTO;
import com.models.SnakeNLadderBoard;
import com.repository.SnakeNLadderBoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderServiceImplTest {

    @InjectMocks
    private SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderServiceImpl();

    @Mock
    private SnakeNLadderBoardRepository snakeNLadderBoardRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllGamesTest() {

        List<SnakeNLadderBoardDTO> snakeNLadderBoardDTOList = new ArrayList<>();
        when(snakeNLadderBoardRepository.findAll()).thenReturn(snakeNLadderBoardDTOList);
        List<SnakeNLadderBoard> snakeNLadderBoards = snakeAndLadderService.getAllGames();
        assertEquals(null, snakeNLadderBoards);


    }

    @Test
    void createGameTest() {

        SnakeNLadderBoard snakeNLadderBoard = new SnakeNLadderBoard();
        SnakeNLadderBoardDTO snakeNLadderBoardDTO = new SnakeNLadderBoardDTO();
        SnakeNLadderBoardDTO snakeNLadderBoardDTO1 = new SnakeNLadderBoardDTO();
        snakeNLadderBoardDTO1.setId(1L);
        snakeNLadderBoard.setName("Timmy");
        snakeNLadderBoard.setSize(10);
        snakeNLadderBoardDTO.setName("Timmy");
        snakeNLadderBoardDTO.setSize(10);
        when(snakeNLadderBoardRepository.save(snakeNLadderBoardDTO)).thenReturn(snakeNLadderBoardDTO1);
        SnakeNLadderBoard snakeNLadderBoard1 = snakeAndLadderService.createGame(snakeNLadderBoard);
        assertEquals(snakeNLadderBoard, snakeNLadderBoard1);
        assertEquals(snakeNLadderBoard1.getName(), "Timmy");
        assertEquals(snakeNLadderBoard1.getSize(), 10);
    }
}