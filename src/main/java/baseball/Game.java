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

            GameNumbers gameNumbers = new GameNumbers(this.getComputerNumber(), playerNumber);
            Scoreboard scoreboard = gameNumbers.compare();

            ConsoleUtil.printLine(scoreboard.toString());

            isRun = scoreboard.getStrikePoint() != strikePoint;
        }
    }

    private int getComputerNumber() {
        return this.computerNumber;
    }
}
