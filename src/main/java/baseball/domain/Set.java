package baseball.domain;

import java.util.List;

public class Set {

    List<String> computerAnswer;
    List<String> userAnswer;
    int ball = 0;
    int strike = 0;
    Count count;

    public Set(List<String> computerAnswer, List<String> userAnswer) {
        this.computerAnswer = computerAnswer;
        this.userAnswer = userAnswer;
        count = new Count(computerAnswer, userAnswer);
    }

    public void startSet(List<String> computerAnswer, List<String> userAnswer) {
        setComputerAnswer(computerAnswer);
        setUserAnswer(userAnswer);
        countBall();
        countStrike();
    }

    public void setUserAnswer(List<String> userInput) {
        this.userAnswer = userInput;
    }

    public void setComputerAnswer(List<String> computerNumber) {
        this.computerAnswer = computerNumber;
    }

    public void countBall() {
        this.ball = count.ballResult;
    }

    public void countStrike() {
        this.strike = count.strikeResult;
    }

}
