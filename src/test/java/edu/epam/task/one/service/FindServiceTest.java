package edu.epam.task.one.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.exception.FileArrayExсeption;
import edu.epam.task.one.util.ArrayFileReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class FindServiceTest {

    public static final String FILE_PATH = "input_files/input_array.txt";
    private static FindService findService;
    private static ArrayFileReader fileReader;
    private static WrapperArray array;

    @BeforeClass
    public static void initialize() throws FileArrayExсeption {
        findService = new FindService();
        fileReader = new ArrayFileReader();
        array = fileReader.fillFromFile(FILE_PATH);
    }

    @Test
    public void equalsBinarySearch() {
        int findItem = -3;
        SortService sortService = new SortService();
        sortService.mergeSort(array);
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

    @Test
    public void equalsPrimes() {
        List<Integer> actualPrimes = findService.getAllPrimes(array);
        List<Integer> expectedPrimes = Arrays.asList(23, 3, -3, 2);
        assertEquals(actualPrimes, expectedPrimes);
    }

    @Test
    public void equalsFibonacciNums() {
        List<Integer> actualFibs = findService.getAllFibNumbers(array);
        List<Integer> expectedFibs = Arrays.asList(3, -3, 2, 0);
        assertEquals(actualFibs, expectedFibs);
    }

    @Test
    public void equals3dNumbers() {
        List<Integer> actualResult = findService.getAll3DigitNumsWithDifferentDigits(array);
        List<Integer> expectedResult = Arrays.asList(154, 516);
        assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public static void clear() {
        findService = null;
        fileReader = null;
        array = null;
    }
}
