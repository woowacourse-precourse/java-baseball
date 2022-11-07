package baseball.domain;

import java.util.ArrayList;

public class BaseballGame {
    int ballCount;
    int strikeCount;
    ArrayList<Integer> answerNumbers;

    public BaseballGame(ArrayList<Integer> randomNumberList) {
        answerNumbers = randomNumberList;
    }

    public void initBaseballGame() {
        ballCount = 0;
        strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public ArrayList<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
