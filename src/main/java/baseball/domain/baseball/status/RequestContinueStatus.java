package baseball.domain.baseball.status;

import baseball.domain.baseball.BaseballGame;
import java.util.Objects;

public class RequestContinueStatus implements BaseballGameStatus {
    private static final Integer RESTART_NUMBER = 1;
    private static final Integer END_NUMBER = 2;

    @Override
    public BaseballGameStatus next(BaseballGame baseballGame) {
        baseballGame.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        baseballGame.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = baseballGame.input();
        this.validateInputIsNumber(input);

        Integer number = Integer.parseInt(input);
        if (isRestartGame(number)) {
            return new GenerateAnswerStatus();
        }
        if (isEndGame(number)) {
            return new GameEndStatus();
        }
        throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
    }

    private boolean isEndGame(Integer number) {
        return Objects.equals(number, END_NUMBER);
    }

    private boolean isRestartGame(Integer number) {
        return Objects.equals(number, RESTART_NUMBER);
    }

    private void validateInputIsNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean runAble() {
        return true;
    }
}
