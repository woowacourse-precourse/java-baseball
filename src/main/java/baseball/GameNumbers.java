package baseball;

import baseball.utils.GameUtil;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private final int computer;
    private final int player;
    private final List<Integer> oneDigitComputerNumbers;
    private final List<Integer> oneDigitPlayerNumbers;

    public GameNumbers(int computer, int player) {
        this.computer = computer;
        this.player = player;
        this.oneDigitComputerNumbers = GameUtil.splitNumberToOneDigits(computer);
        this.oneDigitPlayerNumbers = GameUtil.splitNumberToOneDigits(player);
    }

    public Scoreboard compare() {
        if (this.oneDigitComputerNumbers.equals(this.oneDigitPlayerNumbers)) {
            return new Scoreboard(0, 3); // 3스트라이크
        }

        Scoreboard scoreboard = new Scoreboard();
        List<Integer> retainOneDigitNumbers = new ArrayList<>(this.oneDigitComputerNumbers);

        retainOneDigitNumbers.retainAll(this.oneDigitPlayerNumbers);

        for (int oneDigitNumber : retainOneDigitNumbers) {
            scoreboard.addAllPoint(this.compareOneDigitNumber(oneDigitNumber));
        }

        return scoreboard;
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
