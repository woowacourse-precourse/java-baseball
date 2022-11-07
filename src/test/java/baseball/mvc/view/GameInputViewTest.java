package baseball.mvc.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.helper.util.GameInputViewTestUtils;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameInputViewTest extends OutputSettings {

    @Nested
    @DisplayName("printGameInputLog 메소드는")
    class GameInputViewPrintGameInputLogMethodTest {

        @Test
        @DisplayName("만약 GameStatus.PLAY가 주어지면 개행 없는 플레이어 정답 입력 로그를 출력한다.")
        void play_input_log_test() {
            GameInputView.printGameInputLog(GameStatus.PLAY);

            assertThat(testOut.toString())
                    .isEqualTo(GameInputViewTestUtils
                            .getMessage(GameInputView.ANSWER_INPUT, System.out::print, testOut));
        }

        @Test
        @DisplayName("만약 GameStatus.END가 주어지면 개행 있는 플레이어 게임 재시작 입력 로그를 출력한다.")
        void end_input_log_test() {
            GameInputView.printGameInputLog(GameStatus.END);

            assertThat(testOut.toString())
                    .isEqualTo(GameInputViewTestUtils
                            .getMessage(GameInputView.RESTART_INPUT, System.out::println, testOut));
        }

    }
}