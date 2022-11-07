package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameStatus gameStatus = new GameStatus();
        gameStatus.run();
    }
}
