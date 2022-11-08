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
            throw new IllegalArgumentException("입력할 수 있는 숫자 외의 값을 입력하셨습니다");
        }
    }
}
