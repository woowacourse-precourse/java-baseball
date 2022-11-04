package baseball;

import baseball.utils.GameUtil;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private final List<Integer> oneDigitComputerNumbers;
    private final List<Integer> oneDigitPlayerNumbers;

    public GameNumbers(int computer, int player) {
        this.oneDigitComputerNumbers = GameUtil.splitNumberToOneDigitNumbers(computer);
        this.oneDigitPlayerNumbers = GameUtil.splitNumberToOneDigitNumbers(player);
    }

    public Scoreboard compare() {
        if (this.isThreeStrikes()) {
            return new Scoreboard(0, 3); // 3스트라이크
        }

        Scoreboard scoreboard = new Scoreboard();
        List<Integer> retainOneDigitNumbers = this.retainOneDigitNumbers();

        for (int oneDigitNumber : retainOneDigitNumbers) {
            scoreboard.addAllPoint(this.compareOneDigitNumber(oneDigitNumber));
        }

        return scoreboard;
    }

    private boolean isThreeStrikes() {
        return this.oneDigitComputerNumbers.equals(this.oneDigitPlayerNumbers);
    }

    private List<Integer> retainOneDigitNumbers() {
        List<Integer> retainOneDigitNumbers = new ArrayList<>(this.oneDigitComputerNumbers);

        retainOneDigitNumbers.retainAll(this.oneDigitPlayerNumbers);

        return retainOneDigitNumbers;
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
