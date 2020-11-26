package edu.epam.task.one.entity;

import edu.epam.task.one.exception.WrapperArrayExсeption;

import java.util.Arrays;

public class WrapperArray {

    private int[] array;

    public WrapperArray() {

    }

    public WrapperArray(int... array) {
        this.array = array;
    }

    public WrapperArray(int size) {
        array = new int[size];
    }

    public int getItem(int index) {
        return array[index];
    }

    public void setItem(int item, int index) {
        if ((index < 0) || (index > array.length - 1)) {
            try {
                throw new WrapperArrayExсeption("Incorrect index");
            } catch (WrapperArrayExсeption ex) {
                ex.printStackTrace();
            }
        }
        array[index] = item;
    }

    public int getSize() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof WrapperArray)) {
            return false;
        }
        WrapperArray that = (WrapperArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\narray=").append(Arrays.toString(array)).append("\n");
        return sb.toString();
    }
}
