package edu.epam.task.two.util;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.entity.WrapperJaggedArray;
import edu.epam.task.two.exception.WrapperJaggedArrayFileReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class JaggedArrayFileReader {

    private static final Logger logger = LogManager.getLogger();

    public WrapperJaggedArray fillFromFile(String inputFileName) throws WrapperJaggedArrayFileReaderException {
        File inputFile = new File(inputFileName);
        if (!(inputFile.exists())) {
            throw new WrapperJaggedArrayFileReaderException("Input file doesn't exist");
        }
        String line;
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            logger.fatal("File not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int jaggedSize = data.size();
        int[] sizesOfEachRow = new int[jaggedSize];
        for (int i = 0; i < sizesOfEachRow.length; i++) {
            sizesOfEachRow[i] = data.get(i).split(" ").length;
        }
        WrapperJaggedArray result = new WrapperJaggedArray(jaggedSize);
        for (int i = 0; i < result.getArraySize();) {
            for (int j = 0; j < sizesOfEachRow.length; j++) {
                result.setRow(new WrapperArray(sizesOfEachRow[j]),i++);
            }
        }
        for (int i = 0; i < result.getArraySize(); i++) {
            for (int j = 0; j < result.getRowSize(i); j++) {
                String[] oneDim = data.get(i).split(" ");
                result.setItem(Integer.parseInt(oneDim[j]), i, j);
            }
        }
        logger.info(" {} was filled from {} file successfully", result, inputFileName);
        return result;
    }
}
