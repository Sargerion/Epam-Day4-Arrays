package edu.epam.task.two.service;

import edu.epam.task.one.entity.WrapperArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindJaggedArrayService {

    private static final Logger logger = LogManager.getLogger();

    public int findSumOfRow(WrapperArray row) {
        int sum = 0;
        for (int i = 0; i < row.getSize(); i++) {
            sum += row.getItem(i);
        }
        logger.info("Row's {} sum is {}", row, sum);
        return sum;
    }

    public int findMaxRowItem(WrapperArray row) {
        int maxItem = row.getItem(0);
        for (int i = 0; i < row.getSize(); i++) {
            if (row.getItem(i) > maxItem) {
                maxItem = row.getItem(i);
            }
        }
        logger.info("{} - max item in row {}", maxItem, row);
        return maxItem;
    }

    public int findMinRowItem(WrapperArray row) {
        int minItem = row.getItem(0);
        for (int i = 0; i < row.getSize(); i++) {
            if (row.getItem(i) < minItem) {
                minItem = row.getItem(i);
            }
        }
        logger.info("{} - min item in row {}", minItem, row);
        return minItem;
    }
}
