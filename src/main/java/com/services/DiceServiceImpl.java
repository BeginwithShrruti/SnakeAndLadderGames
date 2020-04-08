package com.services;

import java.util.Random;

public class DiceServiceImpl implements DiceService {
    @Override
    public int roll(int numberOfDice) {

        int result = 0;
        for(int i=0; i<numberOfDice; i++)
        {
            int rand = new Random().nextInt() + 1;
            result = result + rand;
        }
        return result;
    }
}
