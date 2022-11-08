package baseball.domain;

public class Retry {
    public static final String RETRY_NUM = "1";
    public static final String NON_RETRY_NUM = "2";

    private final String retryNum;

    public Retry(String retryNum) {
        isValidNum(retryNum);
        this.retryNum = retryNum;
    }

    private void isValidNum(String retryNum) {
        if (!retryNum.equals(RETRY_NUM) && !retryNum.equals(NON_RETRY_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    public String getRetryNum() {
        return retryNum;
    }
}
