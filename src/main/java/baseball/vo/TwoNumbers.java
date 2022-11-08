package baseball.vo;

public class TwoNumbers {
    private final OneDigitNumbers oneDigitComputerNumbers;
    private final OneDigitNumbers oneDigitPlayerNumbers;

    public TwoNumbers(int computer, int player) {
        this.oneDigitComputerNumbers = new OneDigitNumbers(computer);
        this.oneDigitPlayerNumbers = new OneDigitNumbers(player);
    }

    public Scoreboard compare() {
        if (this.isThreeStrikes()) {
            return new Scoreboard(0, 3); // 3스트라이크
        }

        Scoreboard scoreboard = new Scoreboard();
        OneDigitNumbers retainOneDigitNumbers = this.oneDigitComputerNumbers.retainAll(oneDigitPlayerNumbers);

        for (int oneDigitNumber : retainOneDigitNumbers) {
            scoreboard.addAllPoint(this.compareOneDigitNumber(oneDigitNumber));
        }

        return scoreboard;
    }

    private boolean isThreeStrikes() {
        return this.oneDigitComputerNumbers.equals(this.oneDigitPlayerNumbers);
    }

    private Scoreboard compareOneDigitNumber(int oneDigit) {
        Scoreboard scoreboard = new Scoreboard();

        if (this.oneDigitComputerNumbers.indexOf(oneDigit) == this.oneDigitPlayerNumbers.indexOf(oneDigit)) {
            scoreboard.addStrikePoint();

            return scoreboard;
        }

        scoreboard.addBallPoint();

        return scoreboard;
    }
}