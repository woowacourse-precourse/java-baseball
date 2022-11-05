package baseball;

import static constants.GameConstant.START_GAME_MESSAGE;

public class Application {
    public static void main(String[] args) {
        printStartMessage();
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();
    }

    private static void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }
}
