package baseball.util;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {

    private final Game game;

    public GameManager(Game game) {
        this.game = game;
    }

    public void execute() {
        do {
            game.play();
        } while (restart() == ExecuteStatus.RESTART);
    }

    private ExecuteStatus restart() {
        GamePrinter.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return ExecuteStatus.from(Console.readLine());
    }
}
