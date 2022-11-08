package baseball.model;

import java.util.List;

public class Result {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private int strike = 0;
    private int ball = 0;
    private boolean isNothing = true;
    private final List<Integer> computerNumbers;

    public Result(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.computerNumbers = computerNumbers;
        initializeResult(playerNumbers);
    }

    public boolean strikeAll() {
        return strike == computerNumbers.size();
    }

    public String generateHintMessage() {
        if (isNothing) {
            return NOTHING;
        }
        if (strike == 0) {
            return ball + BALL;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    private void initializeResult(List<Integer> playerNumbers) {
        for (int index = 0; index < playerNumbers.size(); index++) {
            int guessNumber = playerNumbers.get(index);
            countStrikeOrBall(guessNumber, index);
        }
        this.isNothing = hasNothingSame();
    }

    private void countStrikeOrBall(int guess, int index) {
        if (hasNumberAtSameIndex(guess, index)) {
            this.strike++;
            return;
        }
        if (containsSameNumber(guess)) {
            this.ball++;
        }
    }

    private boolean hasNumberAtSameIndex(int guess, int index) {
        return computerNumbers.get(index) == guess;
    }

    private boolean containsSameNumber(int guess) {
        return computerNumbers.contains(guess);
    }

    private boolean hasNothingSame() {
        if (this.strike == 0 && this.ball == 0) {
            return true;
        }
        return false;
    }
}
