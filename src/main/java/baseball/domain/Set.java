package baseball.domain;

import java.util.List;

public class Set {

    List<String> computerAnswer;
    List<String> userAnswer;
    Calculator calculator;

    public Set(List<String> computerAnswer, List<String> userAnswer) {
        calculator = new Calculator(computerAnswer, userAnswer);
        setComputerAnswer(computerAnswer);
        setUserAnswer(userAnswer);
    }

    public int getBall() {
        return calculator.getBallResult();
    }

    public int getStrike() {
        return calculator.getStrikeResult();
    }

    private void setUserAnswer(List<String> userInput) {
        this.userAnswer = userInput;
    }

    private void setComputerAnswer(List<String> computerNumber) {
        this.computerAnswer = computerNumber;
    }

}
