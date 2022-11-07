package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.core.GameStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class GameFlowTest {

    @Test
    void 입력숫자가_123인_경우() {

        String targetNumber = "123";
        String inputNumber = "123";
        BaseballGame baseballGame = new BaseballGame(targetNumber, GameStatus.START);
        GameStatus currentStatus = baseballGame.getCurrentStatus();

        if (currentStatus == START) {
            currentStatus = ONGOING;
            baseballGame.setCurrentStatus(currentStatus);
            currentStatus = executeOnceThenQuit(baseballGame, inputNumber);
        }
        baseballGame.setCurrentStatus(currentStatus);

        Assertions.assertThat(currentStatus).isEqualTo(QUIT);
    }

    @Test
    void 입력숫자가_357인_경우() {

        String targetNumber = "123";
        String inputNumber = "357";
        BaseballGame baseballGame = new BaseballGame(targetNumber, GameStatus.START);
        GameStatus currentStatus = baseballGame.getCurrentStatus();

        if (currentStatus == START) {
            currentStatus = ONGOING;
            baseballGame.setCurrentStatus(currentStatus);
            currentStatus = executeOnceThenQuit(baseballGame, inputNumber);
        }
        baseballGame.setCurrentStatus(currentStatus);

        Assertions.assertThat(currentStatus).isEqualTo(ONGOING);
    }

    // 입력 숫자 하나를 예시로 게임을 한 턴만 실행한 후 게임을 곧바로 종료
    private static GameStatus executeOnceThenQuit(BaseballGame baseballGame, String inputNumber) {
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        String targetNumber = baseballGame.getTargetNumber();
        if (currentStatus == ONGOING) {
            Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
            Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);

            if (numberOfStrike == 3) {
                currentStatus = QUIT;
                baseballGame.setCurrentStatus(currentStatus);
            }
        }
        return currentStatus;
    }

}