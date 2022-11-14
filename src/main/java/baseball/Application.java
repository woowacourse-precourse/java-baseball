package baseball;

import baseball.core.BaseballGame;
import baseball.core.GameFlow;
import baseball.core.GameStatus;
import baseball.core.Initialization;

import static baseball.core.GameStatus.START;

public class Application {
    public static void main(String[] args) {

        GameStatus checkStatus;
        do {
            BaseballGame baseballGame = new BaseballGame(Initialization.createTargetNumber(), START);
            GameStatus nextStatus = GameFlow.playGame(baseballGame);
            checkStatus = nextStatus;
        } while (checkStatus == START);

    }
}
