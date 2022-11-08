package baseball;

import baseball.utils.ConsoleUtil;
import baseball.utils.GameUtil;

public class Game {
    private final int computerNumber;

    public Game(int computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void run(int strikePoint) {
        boolean isRun = true;

        while (isRun) {
            String input = ConsoleUtil.printThreeDigitNumberEnterQuestion();
            int playerNumber = GameUtil.parseInt(input);

            GameUtil.validateNumber(playerNumber);

            TwoNumbers twoNumbers = new TwoNumbers(this.getComputerNumber(), playerNumber);
            Scoreboard scoreboard = twoNumbers.compare();

            ConsoleUtil.printLine(scoreboard.toString());

            isRun = scoreboard.getStrikePoint() != strikePoint;
        }
    }

    private int getComputerNumber() {
        return this.computerNumber;
    }
}
