package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int REQUEST_END = 2;

    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer();
        boolean isEnd = false;
        while (!isEnd) {
            gamePlayer.play();
            isEnd = checkIsEnd(Console.readLine());
        }
    }

    private static boolean checkIsEnd(String whetherValue) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateRestartMessage(whetherValue);
        return Integer.parseInt(whetherValue) == REQUEST_END;
    }
}
