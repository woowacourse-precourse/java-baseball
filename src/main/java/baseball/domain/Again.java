package baseball.domain;

public class Again {
    private static final int EXIT_CODE = 2;

    private static final int GO_CODE = 1;
    private final int doTry;

    public Again(int doTry) {
        this.doTry = doTry;
        validate();
    }

    public int getDoTry() {
        return doTry;
    }

    public void validate() {
        if (this.doTry != EXIT_CODE && this.doTry != GO_CODE) {
            throw new IllegalArgumentException();
        }
    }
}
