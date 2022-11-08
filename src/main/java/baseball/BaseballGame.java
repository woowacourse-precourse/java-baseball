package baseball;

import baseball.domain.BaseballResult;

public class BaseballGame {
    User user;

    public BaseballGame() {
        this.user = new User();
    }

    public boolean askNewGame() {
        if (user.inputRestartNumber() && user.getRestartStatus()) {
            return true;
        }

        return false;
    }

    public void playGame() {
        User user = new User();
        Computer computer = new Computer();
        BaseballResult baseballResult = new BaseballResult();
        boolean correctFlag = false;

        computer.createAnswer();

        while (!correctFlag) {
            user.inputBaseballNumber();
            baseballResult = computer.getCalculateAnswer(user.getUserBaseballNumber());
            System.out.println(baseballResult);

            if (baseballResult.isThreeStrike()) {
                correctFlag = true;
            }
        }
    }
}
