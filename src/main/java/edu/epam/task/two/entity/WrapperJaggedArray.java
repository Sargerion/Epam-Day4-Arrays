package edu.epam.task.two.entity;

import edu.epam.task.one.entity.WrapperArray;
import edu.epam.task.two.exception.WrapperJaggedArrayException;

import java.util.Arrays;

public class WrapperJaggedArray {

    private WrapperArray[] jaggedArray;

    public WrapperJaggedArray(int rows) {
        jaggedArray = new WrapperArray[rows];
    }

    public WrapperJaggedArray(WrapperArray... array) {
        jaggedArray = new WrapperArray[array.length];
        for (int i = 0; i < jaggedArray.length; i++) {
            jaggedArray[i] = array[i];
        }
    }

    public WrapperArray getRow(int index) {
        return jaggedArray[index];
    }

    public void setRow(WrapperArray row, int index) {
        if((index < 0 ) || (index > jaggedArray.length - 1)) {
            try {
                throw new WrapperJaggedArrayException("Incorrect index");
            } catch (WrapperJaggedArrayException e) {
                e.printStackTrace();
            }
        }
        jaggedArray[index] = row;
    }

    public int getArraySize() {
        return jaggedArray.length;
    }

    public int getRowSize(int index) {
        return jaggedArray[index].getSize();
    }

    public int getItem(int rowIndex, int index) {
        return jaggedArray[rowIndex].getItem(index);
    }

    public void setItem(int item, int rowIndex, int index) {
        if ((rowIndex < 0) || (rowIndex > jaggedArray.length - 1)) {
            try {
                throw new WrapperJaggedArrayException("Incorrect indexes");
            } catch (WrapperJaggedArrayException e) {
                e.printStackTrace();
            }
        }
        jaggedArray[rowIndex].setItem(item, index);
    }

    private String getStringVision(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].getSize(); j++) {
                sb.append(jaggedArray[i].getItem(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof WrapperJaggedArray)) {
            return false;
        }
        WrapperJaggedArray jagArr = (WrapperJaggedArray) o;
        return Arrays.equals(jaggedArray, jagArr.jaggedArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(jaggedArray);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggedArray {\n");
        sb.append(getStringVision()).append("}");
        return sb.toString();
    }
}
