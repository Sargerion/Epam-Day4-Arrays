package edu.epam.task.one.service;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.one.util.FibSequenceForFindService;
import edu.epam.task.one.util.SieveForFindService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindService {

    private static final Logger logger = LogManager.getLogger();

    public static final int PRIMES_BOUND = 10000;
    public static final int FIBS_BOUND = 40;

    public int binarySearch(WrapperArray array, int item) {
        int result = binarySearchRealize(array, item, 0, array.getSize() - 1);
        logger.info("Index of {} is {} in array {}", item, result, array);
        return result;
    }

    public int[] findMinAndMax(WrapperArray array) {
        int min = array.getItem(0);
        int max = array.getItem(0);
        for (int i = 0; i < array.getSize(); i++) {
            if(array.getItem(i) < min) {
                min = array.getItem(i);
            } else if(array.getItem(i) > max) {
                max = array.getItem(i);
            }
        }
        logger.info("Min is {} and Max is {} in array {}", min, max, array);
        return new int[] {min, max};
    }

    public List<Integer> getAllPrimes(WrapperArray array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.getSize(); i++) {
            if (isPrime(array.getItem(i))) {
                result.add(array.getItem(i));
            }
        }
        logger.info("Prime numbers {} in array: {}", result, array);
        return result;
    }

    public List<Integer> getAllFibNumbers(WrapperArray array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.getSize(); i++) {
            if (isFib(array.getItem(i))) {
                result.add(array.getItem(i));
            }
        }
        logger.info("Fibonacci numbers {} in array {}", result, array);
        return result;
    }

    public List<Integer> getAll3DigitNumsWithDifferentDigits(WrapperArray array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.getSize(); i++) {
            if(countDigits(array.getItem(i)) == 3) {
                int num1 = array.getItem(i) % 10;
                int num2 = array.getItem(i) % 100 / 10;
                int num3 = array.getItem(i) / 100;
                if (num1 != num2 && num1 != num3 && num2 != num3) {
                    result.add(array.getItem(i));
                }
            }
        }
        logger.info("Numbers with different digits {} in array {}", result, array);
        return result;
    }

    private int binarySearchRealize(WrapperArray array, int item, int start, int end) {
        int mid = (start + end) / 2;
        if(start > end) {
            return -1;
        }
        if (array.getItem(mid) == item) {
            return mid;
        } else if (array.getItem(mid) > item) {
            return binarySearchRealize(array, item, start, mid - 1);
        } else {
            return binarySearchRealize(array, item, mid + 1, end);
        }
    }

    private boolean isPrime(int number) {
        SieveForFindService sieve = new SieveForFindService(PRIMES_BOUND);
        for (int i = 0; i < sieve.getSize(); i++) {
            if (Math.abs(number) == sieve.getItem(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFib(int number) {
        FibSequenceForFindService sequence = new FibSequenceForFindService(FIBS_BOUND);
        for (int i = 0; i < sequence.getSize(); i++) {
            if(sequence.getItem(i) == Math.abs(number)){
                return true;
            }
        }
        return false;
    }

    private int countDigits(int num) {
        int counter = 0;
        if(num == 0) return 1;
        while (num != 0) {
            num /= 10;
            counter++;
        }
        return counter;
    }
}
