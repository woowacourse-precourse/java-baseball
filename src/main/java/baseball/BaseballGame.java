package baseball;

import baseball.resource.AskRestartGame;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public boolean askNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String newGameResult = Console.readLine();

        if (newGameResult.equals(AskRestartGame.RESTART_GAME)) {
            return true;
        }

        if (newGameResult.equals(AskRestartGame.END_GAME)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
