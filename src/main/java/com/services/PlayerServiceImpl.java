package com.services;

import com.dtos.PlayerDTO;
import com.models.Player;
import com.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player createNewPlayer(Player player) {
       PlayerDTO playerDTO = savePlayer(player);
       player.setId(playerDTO.getId());
        return player;
    }

    private PlayerDTO savePlayer(Player player)
    {
        PlayerDTO playerDTO = new PlayerDTO();
        String playerName = player.getName();
        playerDTO.setName(playerName);

        playerRepository.save(playerDTO);
        return playerDTO;
    }
}
