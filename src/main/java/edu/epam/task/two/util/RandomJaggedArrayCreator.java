package edu.epam.task.two.util;

import edu.epam.task.two.entity.WrapperJaggedArray;

import java.util.Random;

public class RandomJaggedArrayCreator {

    private static final int RANDOM_BOUND = 100;

    public void fillFromRandom(WrapperJaggedArray array) {
        Random rnd = new Random();
        for (int i = 0; i < array.getRows(); i++) {
            for (int j = 0; j < array.getColumns(); j++) {
                array.setItem(rnd.nextInt(RANDOM_BOUND), i, j);
            }
        }
    }
}
