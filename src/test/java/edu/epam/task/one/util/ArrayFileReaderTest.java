package edu.epam.task.one.util;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.exception.FileArrayExсeption;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayFileReaderTest {

    public static final String FILE_PATH = "input_files/input_array.txt";
    public static final WrapperArray expectedResultFromFile = new WrapperArray(10, 23, 154, 4, 4, 322, 3, 516, -3, 2, -4, 0, -9);
    private static ArrayFileReader fileReader;
    private static WrapperArray array;

    @BeforeClass
    public static void initialize() throws FileArrayExсeption {
        fileReader = new ArrayFileReader();
        array = fileReader.fillFromFile(FILE_PATH);
    }

    @Test
    public void equalsArrayFromFile() {
        assertEquals(array, expectedResultFromFile);
    }

    @AfterClass
    public static void clear() {
        fileReader = null;
        array = null;
    }
}
