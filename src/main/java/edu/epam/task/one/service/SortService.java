package edu.epam.task.one.service;

import edu.epam.task.one.entity.WrapperArray;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortService {

    private static final Logger logger = LogManager.getLogger();

    public void insertionSort(WrapperArray array) {
        for (int i = 1; i < array.getSize(); i++) {
            int currentPos = i;
            while (currentPos > 0 && array.getItem(currentPos - 1) >  array.getItem(currentPos)) {
                int temp = array.getItem(currentPos);
                array.setItem(array.getItem(currentPos - 1), currentPos);
                array.setItem(temp, currentPos - 1);
                currentPos--;
            }
        }
        logger.info("Insertion sort is complete");
    }

    public void choiceSort(WrapperArray array) {
        for (int i = 0; i < array.getSize() - 1; i++) {
            int indexOfMinItem = i;
            for (int j = i + 1; j < array.getSize(); j++) {
                if(array.getItem(j) < array.getItem(indexOfMinItem)) {
                    indexOfMinItem = j;
                }
            }
            if(i != indexOfMinItem) {
                int temp = array.getItem(i);
                array.setItem(array.getItem(indexOfMinItem), i);
                array.setItem(temp, indexOfMinItem);
            }
        }
        logger.info("Choice sort is complete");
    }

    public void mergeSort(WrapperArray array) {
        mergeSortRealize(array, array.getSize());
        logger.info("Merge sort is complete");
    }

    private void merge(WrapperArray array, WrapperArray leftArray, WrapperArray rightArray, int leftIndex, int rightIndex) {
        int i = 0;
        int j = 0;
        int numerator = 0;
        while (i < leftArray.getSize() && j < rightArray.getSize()) {
            if (leftArray.getItem(i) <= rightArray.getItem(j)) {
                array.setItem(leftArray.getItem(i++), numerator++);
            } else {
                array.setItem(rightArray.getItem(j++), numerator++);
            }
        }
        while (i < leftArray.getSize()) {
            array.setItem(leftArray.getItem(i++), numerator++);
        }
        while (j < rightArray.getSize()) {
            array.setItem(rightArray.getItem(j++), numerator++);
        }
    }

    private void mergeSortRealize(WrapperArray array, int size) {
        if(size < 2) {
            return;
        }
        int mid = size / 2;
        WrapperArray leftArray = new WrapperArray(mid);
        WrapperArray rightArray = new WrapperArray(size - mid);
        for (int i = 0; i < mid; i++) {
            leftArray.setItem(array.getItem(i), i);
        }
        for (int i = mid; i < size; i++) {
            rightArray.setItem(array.getItem(i), i - mid);
        }
        mergeSortRealize(leftArray, mid);
        mergeSortRealize(rightArray, size - mid);
        merge(array, leftArray, rightArray, mid, size - mid);
    }
}
