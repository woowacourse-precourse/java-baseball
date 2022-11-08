package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

    @Nested
    @DisplayName("long strike, long ball을 매개변수로 받는 생성자는")
    class LongLongConstructorTest {

        private static final String TOO_MANY_ANSWER = "잘못된 정답 개수입니다.";

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:0",
                    "1:1",
                    "0:1"
                },
                delimiter = ':'
        )
        @DisplayName("만약 합이 3 이하인 strike, ball가 주어지면 GameResult를 생성한다.")
        void success_test(long strike, long ball) {
            assertThatCode(() -> new GameResult(strike, ball))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "4:0",
                    "3:1",
                    "2:2",
                    "1:3",
                    "0:4"
                },
                delimiter = ':'
        )
        @DisplayName("만약 합이 4 이상인 strike, ball가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void too_large_size_exception(long strike, long ball) {
            assertThatThrownBy(() -> new GameResult(strike, ball))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(TOO_MANY_ANSWER);
        }
    }

    @Nested
    @DisplayName("isOnlyStrike 메소드는")
    class IsOnlyStrikeMethodTest {

        @Test
        @DisplayName("만약 스트라이크가 0보다 크고 볼이 0이면 true를 반환한다.")
        void true_test() {
            GameResult gameResult = new GameResult(1L, 0L);

            assertThat(gameResult.isOnlyStrike()).isTrue();
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:0",
                    "1:1",
                    "0:1"
                },
                delimiter = ':'
        )
        @DisplayName("만약 스트라이크가 0이거나 볼이 0보다 크면 false를 반환한다.")
        void false_test(long strike, long ball) {
            GameResult gameResult = new GameResult(strike, ball);

            assertThat(gameResult.isOnlyStrike()).isFalse();
        }
    }

    @Nested
    @DisplayName("isOnlyBall 메소드는")
    class IsOnlyBallMethodTest {

        @Test
        @DisplayName("만약 스트라이크가 0이고 볼이 0보다 크면 true를 반환한다.")
        void true_test() {
            GameResult gameResult = new GameResult(0L, 1L);

            assertThat(gameResult.isOnlyBall()).isTrue();
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:0",
                    "1:1",
                    "1:0"
                },
                delimiter = ':'
        )
        @DisplayName("만약 스트라이크가 0보다 크거나 볼이 0이면 false를 반환한다.")
        void false_test(long strike, long ball) {
            GameResult gameResult = new GameResult(strike, ball);

            assertThat(gameResult.isOnlyBall()).isFalse();
        }
    }

    @Nested
    @DisplayName("isStrikeAndBall 메소드는")
    class IsStrikeAndBallMethodTest {

        @Test
        @DisplayName("만약 스트라이크와 볼이 모두 0보다 크다면 true를 반환한다.")
        void true_test() {
            GameResult gameResult = new GameResult(1L, 1L);

            assertThat(gameResult.isStrikeAndBall()).isTrue();
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:0",
                    "0:1",
                    "1:0"
                },
                delimiter = ':'
        )
        @DisplayName("만약 스트라이크가 0이거나 볼이 0이라면 false를 반환한다.")
        void false_test(long strike, long ball) {
            GameResult gameResult = new GameResult(strike, ball);

            assertThat(gameResult.isStrikeAndBall()).isFalse();
        }
    }

    @Nested
    @DisplayName("isCorrect 메소드는")
    class IsCorrectMethodTest {

        @Test
        @DisplayName("만약 스트라이크가 3이라면 true를 반환한다.")
        void true_test() {
            GameResult gameResult = new GameResult(3, 0);

            assertThat(gameResult.isCorrect()).isTrue();
        }

        @ParameterizedTest
        @CsvSource(
                value = {
                    "0:0",
                    "1:2",
                    "2:1"
                },
                delimiter = ':'
        )
        @DisplayName("만약 스트라이크가 3이 아니라면 false를 반환한다.")
        void false_test(long strike, long ball) {
            GameResult gameResult = new GameResult(strike, ball);

            assertThat(gameResult.isCorrect()).isFalse();
        }
    }
}