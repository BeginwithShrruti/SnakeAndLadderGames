package com.controllers;

import com.models.Ladder;
import com.models.Player;
import com.models.Snake;
import com.models.SnakeNLadderBoard;
import com.services.PlayerService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPlayerTest() {

        Player player = new Player();
        player.setName("Shruti");
        when(playerService.createNewPlayer(player)).thenReturn(player);
        ResponseEntity<Player> playerResponseEntity = playerController.createPlayer(player);
        assertEquals(playerResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(playerResponseEntity.getBody().getName(), "Shruti");


    }

}