package edu.epam.task.two.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.entity.WrapperJaggedArray;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FindJaggedArrayServiceTest {

    private static FindJaggedArrayService findJaggedArrayService;
    private static WrapperJaggedArray jaggedArray;

    @BeforeClass
    public static void initialize() {
        findJaggedArrayService = new FindJaggedArrayService();
        jaggedArray = new WrapperJaggedArray(new WrapperArray(1, 2, 6), new WrapperArray(4, 100));
    }

    @Test
    public void equalsRowSum() {
        WrapperArray row = jaggedArray.getRow(0);
        int actualRowSum = findJaggedArrayService.findSumOfRow(row);
        int expectedRowSum = 9;
        assertEquals(actualRowSum, expectedRowSum);
    }

    @Test
    public void equalsMaxRowNumber() {
        WrapperArray row = jaggedArray.getRow(1);
        int actualMaxRowNumber = findJaggedArrayService.findMaxRowItem(row);
        int expectedMaxRowNumber = 100;
        assertEquals(actualMaxRowNumber, expectedMaxRowNumber);
    }

    @Test
    public void equalsMinRowNumber() {
        WrapperArray row = jaggedArray.getRow(1);
        int actualMinRowNumber = findJaggedArrayService.findMinRowItem(row);
        int expectedMinRowNumber = 4;
        assertEquals(actualMinRowNumber, expectedMinRowNumber);
    }

    @AfterClass
    public static void cleat() {
        findJaggedArrayService = null;
        jaggedArray = null;
    }
}
