package edu.epam.task.one.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.exception.FileExсeption;
import edu.epam.task.one.util.ArrayFileReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FindServiceTest {

    public static final String FILE_PATH = "input_files/input_array.txt";
    private static FindService findService;
    private static ArrayFileReader fileReader;
    private static WrapperArray array;

    @BeforeClass
    public static void initialize() throws FileExсeption {
        findService = new FindService();
        fileReader = new ArrayFileReader();
        int arraySize = fileReader.getArraySizeFromFile(FILE_PATH);
        array = new WrapperArray(arraySize);
        fileReader.fillFromFile(FILE_PATH, array);
    }

    @Test
    public void equalsBinarySearch() {
        int findItem = -3;
        int actualPosition = findService.binarySearch(array, findItem);
        int expectedPosition = 8;
        assertEquals(actualPosition, expectedPosition);
    }

    @Test
    public void equalsMinAndMax() {
        int[] actualMinAndMax = findService.findMinAndMax(array);
        int[] expectedMinAndMax = new int[] {-9, 516};
        assertEquals(actualMinAndMax, expectedMinAndMax);
    }

    @AfterClass
    public static void clear() {
        findService = null;
        fileReader = null;
        array = null;
    }
}
