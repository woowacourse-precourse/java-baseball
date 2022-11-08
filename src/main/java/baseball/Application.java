package baseball;

import baseball.game.BaseballGame;
import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;

import static baseball.Message.START_MESSAGE;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_MESSAGE);

        AppConfig appConfig = new AppConfig();
        BaseballGame baseballGame = appConfig.baseballGame();
        baseballGame.start();
    }
}
