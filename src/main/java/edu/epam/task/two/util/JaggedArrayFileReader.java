package edu.epam.task.two.util;

import edu.epam.task.one.exception.FileExсeption;
import edu.epam.task.two.entity.WrapperJaggedArray;
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

    public WrapperJaggedArray fillFromFile(String inputFileName) throws FileExсeption{
        File inputFile = new File(inputFileName);
        if (!(inputFile.exists())) {
            throw new FileExсeption("Input file doesn't exist");
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
        int rows = data.size();
        int columns = data.get(0).split(" ").length;
        System.out.println(rows + " " + columns);
        WrapperJaggedArray result = new WrapperJaggedArray(rows, columns);
        for (int i = 0; i < result.getRows(); i++) {
            for (int j = 0; j < result.getColumns(); j++) {
                String[] oneDim = data.get(i).split(" ");
                result.setItem(Integer.parseInt(oneDim[j]), i, j);
            }
        }
        logger.info(" {} was filled from {} file successfully", result, inputFileName);
        return result;
    }
}
