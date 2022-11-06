package baseball.game.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreBoard {

    private int ball;
    private int strike;

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }

    public List<Integer> getBallAndStrike(){
        return Arrays.asList(ball, strike);
    }

    public boolean checkStrikeOut(){
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public void printBallAndStrike() {
        List<String> scoreList = new ArrayList<>();
        if (ball != 0) {
            scoreList.add(ball + "볼");
        }

        if (strike != 0) {
            scoreList.add(strike + "스트라이크");
        }

        if (scoreList.isEmpty()) {
            scoreList.add("낫싱");
        }

        System.out.println(String.join(" ", scoreList));
    }

}
