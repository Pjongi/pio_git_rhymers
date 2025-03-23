package edu.kis.vh.nursery;

public class defaultCountingOutRhymer {

    private static final int ARRAY_SIZE = 12;
    private static final int EMPTY = -1;
    private static final int LAST_INDEX = ARRAY_SIZE - 1;

    private int[] NUMBERS = new int[ARRAY_SIZE];

    public int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public int getTotal() {
        return total;
    }

    public boolean callCheck() {
        return total == EMPTY;
    }

    public boolean isFull() {
        return total == LAST_INDEX;
    }

    protected int peekaboo() {
        if (callCheck())
            return EMPTY;
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY;
        return NUMBERS[total--];
    }
}
