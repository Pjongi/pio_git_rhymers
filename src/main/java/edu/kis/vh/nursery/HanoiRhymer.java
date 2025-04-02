package edu.kis.vh.nursery;

public class HanoiRhymer extends defaultCountingOutRhymer {

    private static final int INITIAL_REJECTED = 0;

    private int totalRejected = INITIAL_REJECTED;

    public int reportRejected() {
        return totalRejected;
    }

    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
