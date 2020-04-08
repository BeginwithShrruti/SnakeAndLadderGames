package com.controllers;

import com.models.Snake;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SnakeController {

    @RequestMapping(value = "/snake", method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Snake> createSnake(@RequestBody Snake snake)
    {
        int success = 0;

        return new ResponseEntity(success,  HttpStatus.OK);
    }
}

