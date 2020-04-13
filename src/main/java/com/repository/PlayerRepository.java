package com.repository;
import com.dtos.PlayerDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDTO, Long> {

}

