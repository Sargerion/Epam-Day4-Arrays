package edu.epam.task.one.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.exception.FileArrayExсeption;
import edu.epam.task.one.util.ArrayFileReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortServiceTest {

    public static final String FILE_PATH = "input_files/input_array.txt";
    public static final WrapperArray expectedSortArray = new WrapperArray(-9, -4, -3, 0, 2, 3, 4, 4, 10, 23, 154, 322, 516);
    private static SortService sortService;
    private static ArrayFileReader fileReader;
    private static WrapperArray array;

    @BeforeClass
    public static void initialize() throws FileArrayExсeption {
        sortService = new SortService();
        fileReader = new ArrayFileReader();
        array = fileReader.fillFromFile(FILE_PATH);
    }

    @Test
    public void equalsInsertionSort() {
        sortService.insertionSort(array);
        assertEquals(array, expectedSortArray);
    }

    @Test
    public void equalsChoiceSort() {
        sortService.choiceSort(array);
        assertEquals(array, expectedSortArray);
    }

    @Test
    public void equalsMergeSort() {
        sortService.mergeSort(array);
        assertEquals(array, expectedSortArray);
    }

    @AfterClass
    public static void clear() {
        sortService = null;
        fileReader = null;
        array = null;
    }
}
