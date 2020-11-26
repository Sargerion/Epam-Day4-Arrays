package edu.epam.task.two.util;

import edu.epam.task.two.entity.WrapperJaggedArray;

import java.util.Random;

public class RandomJaggedArrayCreator {

    private static final int RANDOM_BOUND = 100;

    public void fillFromRandom(WrapperJaggedArray jaggedArray) {
        Random rnd = new Random();
        for (int i = 0; i < jaggedArray.getArraySize(); i++) {
            for (int j = 0; j < jaggedArray.getRowSize(i); j++) {
                jaggedArray.setItem(rnd.nextInt(RANDOM_BOUND), i, j);
            }
        }
    }
}
