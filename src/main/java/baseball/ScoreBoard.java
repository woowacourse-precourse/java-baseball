package baseball;

import java.util.List;
import java.util.Objects;

public class ScoreBoard {

    List<Integer> targetNumber;
    List<Integer> predictedNumber;

    public int getStrikeScore() {

        int strikeScore = 0;
        for (int index = 0; index < 3; index++) {
            if (Objects.equals(targetNumber.get(index), predictedNumber.get(index))) strikeScore++;
        }
        return strikeScore;
    }

    public void display(List<Integer> targetNumber, List<Integer> predictedNumber) {

        this.targetNumber = targetNumber;
        this.predictedNumber = predictedNumber;

        int strikeScore = getStrikeScore();
        printScoreBoard(strikeScore, getBallScore(strikeScore));
    }

    private int getBallScore(int strikeScore) {

        int sameValueCnt = 0;
        for (int index = 0; index < 3; index++) {
            if (targetNumber.contains(predictedNumber.get(index))) sameValueCnt++;
        }
        return sameValueCnt - strikeScore;
    }

    private void printScoreBoard(int strikeScore, int ballScore) {

        if (strikeScore == 0 && ballScore == 0) {
            System.out.println("낫싱");
        } else if (strikeScore == 3 || ballScore == 0) {
            System.out.println(strikeScore + "스트라이크");
        } else if (ballScore == 3 || strikeScore == 0) {
            System.out.println(ballScore + "볼");
        } else {
            System.out.println(ballScore + "볼 " + strikeScore + "스트라이크");
        }
    }
}
