package edu.epam.task.one.util;

import edu.epam.task.one.entity.WrapperArray;

import java.util.Random;

public class RandomCreator {

    public static final int RANDOM_BOUND = 1000;

    public void fillFromRandom(WrapperArray array) {
        Random rnd = new Random();
        for (int i = 0; i < array.getSize(); i++) {
            array.setItem(rnd.nextInt(RANDOM_BOUND), i);
        }
    }
}
