package baseball;

import static baseball.BaseballGame.Game;
import static baseball.BaseballGame.isGameRestart;
import static baseball.Constants.Message.START_MSG;


public class Application {
    public static void main(String[] args) {
        System.out.println(START_MSG);
        do {
            Game();
        } while (isGameRestart());
    }
}
