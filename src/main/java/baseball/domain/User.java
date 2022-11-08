package baseball.domain;

public class User {
    private String userBaseballNumber;
    private String userRestartNumber;

    public String getBaseballNumber() {
        return this.userBaseballNumber;
    }

    public void setBaseballNumber(String userInput) {
        this.userBaseballNumber = userInput;
    }

    public String getRestartNumber() {
        return this.userRestartNumber;
    }

    public void setUserRestartNumber(String userInput) {
        this.userRestartNumber = userInput;
    }
}
