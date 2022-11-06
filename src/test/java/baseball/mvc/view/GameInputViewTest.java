package baseball.mvc.view;

import baseball.util.GameInputViewTestUtils;
import baseball.util.GameStatus;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameInputViewTest {

    private static final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private static PrintStream standardOut;

    @BeforeEach
    void beforeEach() {
        testOut.reset();
        standardOut = System.out;
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
        System.out.println(testOut.toString().trim());
    }

    @Nested
    @DisplayName("printGameInputLog 메소드는")
    class GameInputViewPrintGameInputLogMethodTest {

        @Test
        @DisplayName("만약 GameStatus.PLAY가 주어지면 개행 없는 플레이어 정답 입력 로그를 출력한다.")
        void play_input_log_test() {
            GameInputView.printGameInputLog(GameStatus.PLAY);

            Assertions.assertThat(testOut.toString())
                    .isEqualTo(GameInputViewTestUtils
                            .getMessage(GameInputView.ANSWER_INPUT, System.out::print, testOut));
        }

        @Test
        @DisplayName("만약 GameStatus.END가 주어지면 개행 있는 플레이어 게임 재시작 입력 로그를 출력한다.")
        void end_input_log_test() {
            GameInputView.printGameInputLog(GameStatus.END);

            Assertions.assertThat(testOut.toString())
                    .isEqualTo(GameInputViewTestUtils
                            .getMessage(GameInputView.RESTART_INPUT, System.out::println, testOut));
        }

    }
}