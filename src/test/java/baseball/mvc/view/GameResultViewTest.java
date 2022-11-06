package baseball.mvc.view;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.game.GameResult;
import baseball.util.GameResultViewTestUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultViewTest {

    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private PrintStream standardOut;

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
    @DisplayName("printGameResultLog 메소드는")
    class PrintGameResultLogMethodTest {

        @ParameterizedTest
        @CsvSource(
            value = {
                "1:1",
                "1:2",
                "2:1"
            },
            delimiter = ':'
        )
        @DisplayName("만약 스트라이크와 볼이 있는 GameResult가 주어진다면 ?볼 ?스트라이크라는 형식의 문구를 출력한다.")
        void strike_and_ball_log_test(long strike, long ball) {
            GameResult gameResult = new GameResult(strike, ball);
            GameResultView.printGameResultLog(gameResult);

            Assertions
                .assertThat(testOut.toString())
                .isEqualTo(GameResultViewTestUtils
                    .getMessage(GameResultView.STRIKE_AND_BALL, gameResult, testOut));
        }

        @ParameterizedTest
        @ValueSource(longs = {1L, 2L, 3L})
        @DisplayName("만약 볼만 있는 GameResult가 주어진다면 ?볼이라는 형식의 문구를 출력한다.")
        void only_ball_log_test(long ball) {
            GameResult gameResult = new GameResult(0L, ball);
            GameResultView.printGameResultLog(gameResult);

            Assertions
                .assertThat(testOut.toString())
                .isEqualTo(GameResultViewTestUtils
                    .getMessage(GameResultView.ONLY_BALL, gameResult, testOut));
        }

        @ParameterizedTest
        @ValueSource(longs = {1L, 2L, 3L})
        @DisplayName("만약 스트라이크만 있는 GameResult가 주어진다면 ?스트라이크라는 형식의 문구를 출력한다.")
        void only_strike_log_test(long strike) {
            GameResult gameResult = new GameResult(strike, 0L);
            GameResultView.printGameResultLog(gameResult);

            Assertions
                .assertThat(testOut.toString())
                .isEqualTo(GameResultViewTestUtils
                    .getMessage(GameResultView.ONLY_STRIKE, gameResult, testOut));
        }

        @Test
        @DisplayName("만약 아무것도 없는 GameResult가 주어진다면 낫싱을 출력한다.")
        void nothing_log_test() {
            GameResult gameResult = new GameResult(0L, 0L);
            GameResultView.printGameResultLog(gameResult);

            Assertions
                .assertThat(testOut.toString())
                .isEqualTo(GameResultViewTestUtils
                    .getMessage(GameResultView.NOTHING, gameResult, testOut));
        }
    }
}