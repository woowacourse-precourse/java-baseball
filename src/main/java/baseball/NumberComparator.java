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
}
