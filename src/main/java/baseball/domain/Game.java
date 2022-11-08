package baseball.domain;

import java.util.List;

public class Game {
    private static final int MAX_STRIKE_SIZE = 3;
    private static final int ONE = 1;
    private static final boolean SUCCESS = false;
    private static final boolean FAIL = true;
    private int strike;
    private int ball;

    public Game() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void addBall() {
        this.ball += ONE;
    }

    public void addStrike() {
        this.strike += ONE;
        this.ball -= ONE;
    }

    public void checkBall(List<Integer> computerAnswer, List<Integer> UserAnswer) {
        for (int aLetter : UserAnswer) {
            if (letterIncludeAnswerCheck(computerAnswer, aLetter)) {
                addBall();
                checkStrike(computerAnswer, UserAnswer, aLetter);
            }
        }
    }

    public void checkStrike(List<Integer> computerAnswer, List<Integer> UserAnswer, int aLetter) {
        if (computerAnswer.indexOf(aLetter) == UserAnswer.indexOf(aLetter)) {
            addStrike();
        }
    }

    public boolean ThreeStrikeCheck() {
        if (this.strike == MAX_STRIKE_SIZE) {
            return SUCCESS;
        }
        return FAIL;
    }

    public boolean letterIncludeAnswerCheck(List<Integer> computerAnswer, int aLetter) {
        return computerAnswer.contains(aLetter);
    }
}
