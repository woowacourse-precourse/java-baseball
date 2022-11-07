package baseball.game;

import baseball.object.GameStatus;

public class EndGame {

    public static Boolean isRestart(Integer userInput) {

        checkInputRange(userInput);
        return userInput == GameStatus.RESTART.getValue();
    }

    private static void checkInputRange(Integer input) {

        if (input != GameStatus.RESTART.getValue() && input != GameStatus.END.getValue()) {
            throw new IllegalArgumentException("Argument length out of range");
        }
    }
}
