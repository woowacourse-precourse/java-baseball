package baseball;

import baseball.controller.GameController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PlayerInputTest {
    GameController gameController = new GameController();

    @Test
    void 사용자_답변_유효성_검사_재시작() {
        String playerAnswer = "1";
        assertThat(gameController.wantRestartGame(playerAnswer)).isTrue();
    }

    @Test
    void 사용자_답변_유효성_검사_종료() {
        String playerAnswer = "2";
        assertThat(gameController.wantRestartGame(playerAnswer)).isFalse();
    }

    @Test
    void 사용자_답변_유효성_검사_오류() {
        String playerAnswer = "4";
        String exceptionMessage = "1 혹은 2만 입력 가능합니다.";

        Throwable throwable = catchThrowable(() -> {
            gameController.wantRestartGame(playerAnswer);
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage(exceptionMessage);
    }
}
