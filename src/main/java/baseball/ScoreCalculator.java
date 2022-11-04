package baseball;


import baseball.score.NStrikeNBallScore;
import baseball.score.NothingScore;
import baseball.score.Score;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ScoreCalculator {
    List<Score> scoreList;

    public ScoreCalculator() {
        scoreList = new ArrayList<>();
        scoreList.addAll(Arrays.asList(new NStrikeNBallScore(3, 0), new NothingScore()));
        for (int strike = 0; strike < 3; strike++) {
            addScoreList(strike);
        }
    }

    private void addScoreList(int strike) {
        for (int ball = 0; ball < 4 - strike; ball++) {
            if (strike == 0 && ball == 0) continue;
            scoreList.add(new NStrikeNBallScore(strike, ball));
        }
    }

    public Score calculateScore(int expect, int actual) {
        int strike = calculateStrike(expect, actual);
        int ball = calculateBall(expect, actual);
        return scoreList.stream().filter((x) -> x.isSame(strike, ball)).findFirst().get();
    }

    private int calculateBall(int expect, int actual) {
        int ball = 0;
        ball -= calculateStrike(expect, actual);
        Set<Integer> expectSet = new HashSet<>();
        while (expect != 0) {
            expectSet.add(expect % 10);
            expect /= 10;
        }
        while (actual != 0) {
            if (expectSet.contains(actual % 10)) ball++;
            actual /= 10;
            expect /= 10;
        }
        if (ball < 0) return 0;
        return ball;
    }

    private int calculateStrike(int expect, int actual) {
        int strike = 0;
        while (actual != 0) {
            if (actual % 10 == expect % 10) strike++;
            actual /= 10;
            expect /= 10;
        }
        return strike;
    }
}