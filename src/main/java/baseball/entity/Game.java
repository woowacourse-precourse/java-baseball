package baseball.entity;

import java.util.List;

public class Game {
    int strikeCounter;
    int ballCounter;
    List<Integer> answer;

    public void initialGameValue() {
        this.strikeCounter = 0;
        this.ballCounter = 0;
    }
    public int getStrikeCounter() {
        return strikeCounter;
    }

    public int getBallCounter() {
        return ballCounter;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public void incBallCounter() {
        this.ballCounter += 1;
    }

    public void incStrikeCounter() {
        this.strikeCounter += 1;
    }

}
