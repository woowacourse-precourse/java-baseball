package baseball;

import static baseball.domain.BaseballGameStarter.*;
import static baseball.global.constants.Constants.Korean.GAME_START_MESSAGE;


public class Application {

    public static void main(String[] args) {
        printGameStartMessage();
        playBaseballGame();
    }

    private static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
