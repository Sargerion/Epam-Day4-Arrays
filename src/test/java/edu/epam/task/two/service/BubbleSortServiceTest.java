package edu.epam.task.two.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.comparator.MaxNumberComparator;
import edu.epam.task.two.comparator.MinNumberComparator;
import edu.epam.task.two.comparator.SumComparator;
import edu.epam.task.two.constant.SortChoice;
import edu.epam.task.two.entity.WrapperJaggedArray;
import edu.epam.task.two.exception.WrapperJaggedArrayFileReaderException;
import edu.epam.task.two.util.JaggedArrayFileReader;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BubbleSortServiceTest {

    public static final String FILE_PATH = "input_files/input_jagged_array.txt";
    public static final WrapperJaggedArray expectedSortArrayBySum = new WrapperJaggedArray(new WrapperArray(1, 253, 4, 90, 1, 60),
            new WrapperArray(10, 23, 154, 4, 32), new WrapperArray(0, 15), new WrapperArray(8, -3, 2, -87));
    public static final WrapperJaggedArray expectedSortArrayByMaxNumber = new WrapperJaggedArray(new WrapperArray(1, 253, 4, 90, 1, 60),
            new WrapperArray(10, 23, 154, 4, 32), new WrapperArray(0, 15), new WrapperArray(8, -3, 2, -87));
    public static final WrapperJaggedArray expectedSortArrayByMinNumber = new WrapperJaggedArray(new WrapperArray(10, 23, 154, 4, 32),
            new WrapperArray(1, 253, 4, 90, 1, 60), new WrapperArray(0, 15), new WrapperArray(8, -3, 2, -87));
    public static final SortChoice SORT_CHOICE = SortChoice.INCREASE;
    private static JaggedArrayFileReader fileReader;
    private static BubbleSortService bubbleSortService;
    private static SumComparator sumComparator;
    private static MaxNumberComparator maxNumberComparator;
    private static MinNumberComparator minNumberComparator;
    private static WrapperJaggedArray array;

    @BeforeClass
    public static void initialize() throws WrapperJaggedArrayFileReaderException {
        fileReader = new JaggedArrayFileReader();
        bubbleSortService = new BubbleSortService();
        sumComparator = new SumComparator();
        maxNumberComparator = new MaxNumberComparator();
        minNumberComparator = new MinNumberComparator();
        array = fileReader.fillFromFile(FILE_PATH);
    }

    @Test
    public void equalsSortBySum() {
        bubbleSortService.sort(array, sumComparator, SORT_CHOICE);
        assertEquals(array, expectedSortArrayBySum);
    }

    @Test
    public void equalsSortByMaxNumber() {
        bubbleSortService.sort(array, maxNumberComparator, SORT_CHOICE);
        assertEquals(array, expectedSortArrayByMaxNumber);
    }

    @Test
    public void equalsSortByMinNumber() {
        bubbleSortService.sort(array, minNumberComparator, SORT_CHOICE);
        assertEquals(array, expectedSortArrayByMinNumber);
    }

    @AfterClass
    public static void clear() {
        fileReader = null;
        bubbleSortService = null;
        sumComparator = null;
        maxNumberComparator = null;
        minNumberComparator = null;
        array = null;
    }
}
