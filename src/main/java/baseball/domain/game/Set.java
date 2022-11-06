package baseball.domain.game;

import java.util.List;

public class Set {

    List<String> computerAnswer;
    List<String> userAnswer;
    int ball = 0;
    int strike = 0;
    Count count;

    public Set() {
        count = new Count();
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
        this.ball = count.countBall(computerAnswer, userAnswer);
    }

    public void countStrike() {
        this.strike = count.countStrike(computerAnswer, userAnswer);
    }

}
