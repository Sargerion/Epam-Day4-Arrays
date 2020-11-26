package edu.epam.task.two.util;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.entity.WrapperJaggedArray;
import edu.epam.task.two.exception.WrapperJaggedArrayFileReaderException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayFileReaderTest {

    public static final String FILE_PATH = "input_files/input_jagged_array.txt";
    public static WrapperJaggedArray expectedResultFromFile = new WrapperJaggedArray(new WrapperArray(10, 23, 154, 4, 32),
            new WrapperArray(8, -3, 2, -87), new WrapperArray(0, 15), new WrapperArray(1, 253, 4, 90, 1, 60));
    private static JaggedArrayFileReader jaggedArrayFileReader;
    private static WrapperJaggedArray jaggedArray;

    @BeforeClass
    public static void initialize() throws WrapperJaggedArrayFileReaderException {
        jaggedArrayFileReader = new JaggedArrayFileReader();
        jaggedArray = jaggedArrayFileReader.fillFromFile(FILE_PATH);
    }

    @Test
    public void equalsJaggedArrayFromFile() {
        assertEquals(jaggedArray, expectedResultFromFile);
    }

    @AfterClass
    public static void clear() {
        jaggedArrayFileReader = null;
        jaggedArray = null;
    }
}
