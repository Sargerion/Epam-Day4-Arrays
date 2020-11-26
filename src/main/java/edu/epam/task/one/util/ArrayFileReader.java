package edu.epam.task.one.util;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.exception.FileExсeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayFileReader {

    private static final Logger logger = LogManager.getLogger();

    public void fillFromFile(String inputFileName, WrapperArray array) throws FileExсeption {
        File inputFile = new File(inputFileName);
        if (!(inputFile.exists())) {
            throw new FileExсeption("Input file doesn't exist");
        }
        String line;
        Scanner scanner = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                line = line.substring(line.indexOf(":") + 1, line.length());
                scanner = new Scanner(line).useDelimiter(" ");
                for (int i = 0; i < array.getSize(); i++) {
                    array.setItem(scanner.nextInt(), i);
                }
            }
        } catch (FileNotFoundException e) {
            logger.fatal("File not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        logger.info(" {} was filled from {} file successfully", array, inputFileName);
    }

    public int getArraySizeFromFile(String inputFileName) throws FileExсeption {
        File inputFile = new File(inputFileName);
        if (!(inputFile.exists())) {
            throw new FileExсeption("Input file doesn't exist");
        }
        int size = 0;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = reader.readLine()) != null) {
                size = Integer.parseInt(line.substring(line.indexOf("(") + 1, line.indexOf(")")));
            }
        } catch (FileNotFoundException e) {
            logger.fatal("File not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return size;
    }
}
