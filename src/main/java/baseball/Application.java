package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.turnOnGame();
        do {
            Computer computer = new Computer();
            Round round = new Round(computer);
            game.startNewGame(computer);
        } while (game.replayGame());

    }
}
