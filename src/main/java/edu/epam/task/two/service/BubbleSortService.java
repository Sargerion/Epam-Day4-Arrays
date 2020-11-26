package edu.epam.task.two.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.constant.SortChoice;
import edu.epam.task.two.entity.WrapperJaggedArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class BubbleSortService {

    private static final Logger logger = LogManager.getLogger();

    public void sort(WrapperJaggedArray jaggedArray, Comparator<WrapperArray> comparator, SortChoice choice) {
        switch (choice) {
            case INCREASE -> {
                for (int i = 0; i < jaggedArray.getArraySize() - 1; i++) {
                    for (int j = i + 1; j < jaggedArray.getArraySize(); j++) {
                        if (comparator.compare(jaggedArray.getRow(i), jaggedArray.getRow(j)) < 0) {
                            WrapperArray tempRow = jaggedArray.getRow(i);
                            jaggedArray.setRow(jaggedArray.getRow(j), i);
                            jaggedArray.setRow(tempRow, j);
                        }
                    }
                }
            }
            case DECREASE -> {
                for (int i = 0; i < jaggedArray.getArraySize() - 1; i++) {
                    for (int j = i + 1; j < jaggedArray.getArraySize(); j++) {
                        if (comparator.compare(jaggedArray.getRow(i), jaggedArray.getRow(j)) > 0) {
                            WrapperArray tempRow = jaggedArray.getRow(i);
                            jaggedArray.setRow(jaggedArray.getRow(j), i);
                            jaggedArray.setRow(tempRow, j);
                        }
                    }
                }
            }
        }
        logger.info("Bubble sort by {} completed successfully : result {}", comparator.getClass(), jaggedArray);
    }
}