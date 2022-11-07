package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballContext;
import java.util.Objects;

public class RequestContinueStatus implements BaseballGameStatus {
    public static final String ERROR_CONTINUOUS_INPUT = "[ERROR] 1과_2를 제외한 값을 입력할 수 없습니다.";
    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";

    @Override
    public BaseballGameStatus next(BaseballContext baseballContext) {
        baseballContext.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        baseballContext.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = baseballContext.input();
        
        if (isRestartGame(input)) {
            return new GenerateAnswerStatus();
        }
        if (isEndGame(input)) {
            return new GameEndStatus();
        }
        throw new IllegalArgumentException(ERROR_CONTINUOUS_INPUT);
    }

    private boolean isEndGame(final String input) {
        return Objects.equals(input, END_NUMBER);
    }

    private boolean isRestartGame(final String input) {
        return Objects.equals(input, RESTART_NUMBER);
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
