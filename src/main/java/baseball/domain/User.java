package baseball.domain;

import java.util.List;

public class User {

    private final Referee referee;

    public User(Referee referee) {
        this.referee = referee;
    }

    private List<Integer> userNumber;

    public void inputUserNum(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public void compareNumber() {
        referee.compareNumbers(userNumber);
    }
}
