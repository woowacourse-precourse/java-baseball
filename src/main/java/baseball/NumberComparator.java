package baseball;

public class NumberComparator {
    private final int numberSize;
    private final String NOTHING = "낫싱";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String SPACE = " ";

    public NumberComparator(int numberSize) {
        this.numberSize = numberSize;
    }

    private boolean isStrike(User user, Computer computer, int index) {
        return user.getNumber(index) == computer.getNumber(index);
    }

    private boolean isBall(User user, Computer computer, int index) {
        int userNumber = user.getNumber(index);
        return (computer.getNumber(index) != userNumber)
                && (computer.contains(user.getNumber(index)));
    }

    private int getStrikeCount(User user, Computer computer) {
        int strikeCount = 0;

        for (int index = 0; index < numberSize; index++) {
            if (isStrike(user, computer, index)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int getBallCount(User user, Computer computer) {
        int ballCount = 0;

        for (int index = 0; index < numberSize; index++) {
            if (isBall(user, computer, index)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private void makeStrikeCountText(StringBuilder gameResultBuilder, int strikeCount) {
        if (strikeCount > 0) {
            gameResultBuilder.append(strikeCount);
            gameResultBuilder.append(STRIKE);
            gameResultBuilder.append(SPACE);
        }
    }
}
