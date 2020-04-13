package com.repository;
import com.dtos.SnakeNLadderBoardDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface SnakeNLadderBoardRepository extends CrudRepository<SnakeNLadderBoardDTO, Long> {

    }

