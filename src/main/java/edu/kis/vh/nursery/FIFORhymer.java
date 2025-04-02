package edu.kis.vh.nursery;

public class FIFORhymer extends defaultCountingOutRhymer {

    private static final defaultCountingOutRhymer DEFAULT_TEMP = new defaultCountingOutRhymer();
    private defaultCountingOutRhymer temp = DEFAULT_TEMP;

    public void setTemp(defaultCountingOutRhymer temp) {
        this.temp = temp;
    }

    @Override
    public int countOut() {
        while (!callCheck()) {
            temp.countIn(super.countOut());
        }

        int ret = temp.countOut();

        while (!temp.callCheck()) {
            countIn(temp.countOut());
        }

        return ret;
    }
}
