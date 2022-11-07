package baseball.domain;

public class Again {
    private static final int  EXCEPTION = -1;
    private static final int  ALL_RIGHT = 1;

    private static final int EXIT_CODE = 2;

    private static final int GO_CODE = 1;
    private int doTry;

    public Again(int doTry) {
        this.doTry = doTry;
        validate();
    }

    public int getDoTry() {
        return doTry;
    }

    public void validate() {
        if (againValueCheck(doTry) == EXCEPTION) {
            throw new IllegalArgumentException();
        }
    }

    public int againValueCheck(int doTry) {
        if (doTry == EXIT_CODE || doTry == GO_CODE) {
            return ALL_RIGHT;
        }
        return EXCEPTION;
    }
}
