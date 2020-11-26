package edu.epam.task.one.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveForFindService {

    private boolean[] sieve;
    private int size;
    private List<Integer> primes;

    public SieveForFindService(int size) {
        this.size = size;
        sieve = new boolean[size];
        primes = new ArrayList<>();
        fillPrimes();
    }

    public int getSize() {
        return primes.size();
    }

    public int getItem(int index) {
        return primes.get(index);
    }

    private void fillPrimes() {
        Arrays.fill(sieve, true);
        for (int i = 2; i * i < size; i++) {
            if (sieve[i]) {
                for (int j = i * i; j < size; j += i) {
                    sieve[j] = false;
                }
            }
        }
        for (int i = 2; i < size; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
    }
}
