package edu.epam.task.two.entity;

import edu.epam.task.two.exception.WrapperJaggedArrayException;

import java.util.Arrays;

public class WrapperJaggedArray {

    private int rows;
    private int columns;
    private int[][] array;

    public WrapperJaggedArray(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        array = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getItem(int rowIndex, int columnIndex) {
        return array[rowIndex][columnIndex];
    }

    public void setItem(int item, int rowIndex, int columnIndex) {
        if((rowIndex < 0 || rowIndex > rows - 1) && (columnIndex < 0 || columnIndex > columns - 1)) {
            try {
                throw new WrapperJaggedArrayException("Incorrect indexes");
            } catch (WrapperJaggedArrayException ex) {
                ex.printStackTrace();
            }
        }
        array[rowIndex][columnIndex] = item;
    }

    private String getStringVision(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(array[i][j]).append(" ");
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
        WrapperJaggedArray that = (WrapperJaggedArray) o;
        return (rows == that.rows) && (columns == that.columns) && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(rows);
        result = 31 * result + Integer.hashCode(columns) + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{\n");
        sb.append("array=\n").append(getStringVision()).append("}");
        return sb.toString();
    }
}
