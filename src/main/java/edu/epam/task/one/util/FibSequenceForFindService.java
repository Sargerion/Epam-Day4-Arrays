package edu.epam.task.one.util;

public class FibSequenceForFindService {

    private int[] sequence;
    private int size;

    public FibSequenceForFindService(int size) {
        this.size = size;
        sequence = new int[size];
        fillSequence();
    }

    public int getSize() {
        return size;
    }

    public int getItem(int index) {
        return sequence[index];
    }

    private void fillSequence() {
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < size; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 1];
        }
    }
}
