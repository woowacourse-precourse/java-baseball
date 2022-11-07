package baseball.console;

import static baseball.game.GameRule.BASEBALL_STRIKE_WIN_COUNT;
import static baseball.game.GameStatus.GAME_END;
import static baseball.game.GameStatus.GAME_RESTART;

public enum ConsoleOutputMessage {
    START_BASEBALL_GAME("숫자 야구 게임을 시작합니다."),
    INPUT_BASEBALL_NUMBER("숫자를 입력해주세요 : "),
    WINNER_COMMENT(BASEBALL_STRIKE_WIN_COUNT.getRule() + "개의 숫자를 모두 맞히셨습니다! "),
    WINNER_END_COMMENT("게임 종료"),
    EXPLAIN_ANOTHER_GAME("게임을 새로 시작하려면 " + GAME_RESTART.getType() + ", " +
            "종료하려면 " + GAME_END.getType() + "를 입력하세요.");

    private final String message;

    ConsoleOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
