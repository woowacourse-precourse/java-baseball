package baseball.service;

import java.util.Objects;

public class Service {

    public int findBall(int score, int input) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            count += findDeepBall(score, i, input);
            score /= 10;
        }
        return count;
    }

    private static int findDeepBall(int score, int i, int input) {
        int count = 0;
        for (int j = 0; j < 3; j++) {
            if (Objects.equals(i, j)) {
                input /= 10;
                continue;
            }
            if (Objects.equals(input % 10, score % 10)) count++;
            input /= 10;
        }
        return count;
    }

    public int findStrike(int score, int input) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(score % 10, input % 10)) count++;
            score /= 10;
            input /= 10;
        }
        return count;
    }
}
