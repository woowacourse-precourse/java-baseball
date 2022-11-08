package baseball.domain;

import java.util.List;

public class Set {

    List<String> computerAnswer;
    List<String> userAnswer;
    Calculator calculator;
    int ball = 0;
    int strike = 0;

    public Set(List<String> computerAnswer, List<String> userAnswer) {
        calculator = new Calculator(computerAnswer, userAnswer);
        setComputerAnswer(computerAnswer);
        setUserAnswer(userAnswer);
        countBall();
        countStrike();
    }

    private void setUserAnswer(List<String> userInput) {
        this.userAnswer = userInput;
    }

    private void setComputerAnswer(List<String> computerNumber) {
        this.computerAnswer = computerNumber;
    }

    private void countBall() {
        this.ball = calculator.ballResult;
    }

    private void countStrike() {
        this.strike = calculator.strikeResult;
    }

}
