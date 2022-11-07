package baseball.core;

import camp.nextstep.edu.missionutils.Console;

import static baseball.core.GameStatus.*;

public class GameFlow {

    public static GameStatus getNextStatus(BaseballGame baseballGame) {
        GameStatus currentStatus = baseballGame.getCurrentStatus();

        while (currentStatus == START) {
            currentStatus = ONGOING;
            baseballGame.setCurrentStatus(currentStatus);
            currentStatus = executeGame(baseballGame);
        }
        baseballGame.setCurrentStatus(currentStatus);
        return currentStatus;
    }

    private static GameStatus executeGame(BaseballGame baseballGame) {
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        String targetNumber = baseballGame.getTargetNumber();
        while (currentStatus == ONGOING) {
            String inputNumber = Console.readLine();
            Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
            Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);

            if (numberOfStrike == 3) {
                String selectGameStatus = Console.readLine();
                if (selectGameStatus == "1") currentStatus = START;
                else if (selectGameStatus == "2") currentStatus = QUIT;
                baseballGame.setCurrentStatus(currentStatus);
            }
        }
        return currentStatus;
    }
}
