package baseball.service;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class GameManager {

    public static void execute(Game game) {
        do {
            game.play();
        } while (getPlayerWant() == GameStatus.RESTART);
    }

    private static GameStatus getPlayerWant() {
        printGameRestartGuideMessage();
        String input = Console.readLine();
        return getPlayerWantStatus(input);
    }

    private static void printGameRestartGuideMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    private static GameStatus getPlayerWantStatus(String input) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.getCode().equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @code 변수는 사용자가 입력한 값을 의미합니다. 따라서 GameStatus 내에서 각 code 값은 unique 해야 합니다.
     */
    private enum GameStatus {
        RESTART("1"), END("2");

        final String code;

        GameStatus(String s) {
            code = s;
        }

        public String getCode() {
            return code;
        }
    }
}
