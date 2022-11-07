package baseball.domain.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.util.GameNumberConst;
import baseball.helper.util.GameNumbersTestUtils;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumbersTest {

    @Nested
    @DisplayName("기본 생성자는")
    class DefaultConstructorTest {

        @Test
        @DisplayName("만약 호출된다면 중복되지 않는 세 개의 GameNumber를 생성해 gameNumbers 필드를 초기화한 GameNumbers를 반환한다.")
        void success_test() {
            GameNumbers gameNumbers = new GameNumbers();

            List<GameNumber> gameNumberList = GameNumbersTestUtils.getGameNumberList(gameNumbers);
            int uniqueGameNumberCount = Long.valueOf(gameNumberList.stream().distinct().count()).intValue();

            assertThat(uniqueGameNumberCount).isSameAs(GameNumberConst.MAX_GAME_NUMBER_SIZE);
        }
    }

    @Nested
    @DisplayName("String playerAnswer를 매개변수로 받는 생성자는")
    class StringConstructorTest {

        private static final String WRONG_NUMBER = "허용되지 않는 숫자입니다.";
        private static final String WRONG_INPUT = "잘못된 입력입니다.";

        @Test
        @DisplayName("만약 조건에 맞는 playerAnswer가 주어지면 세 개의 GameNumber를 생성해 gameNumbers 필드를 초기화한 GameNumbers를 반환한다.")
        void success_test() {
            GameNumbers gameNumbers = new GameNumbers("123");

            List<GameNumber> gameNumberList = GameNumbersTestUtils.getGameNumberList(gameNumbers);
            int uniqueGameNumberCount = Long.valueOf(gameNumberList.stream().distinct().count()).intValue();

            assertThat(uniqueGameNumberCount).isSameAs(GameNumberConst.MAX_GAME_NUMBER_SIZE);
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "112",
                    "1",
                    "1234"
                }
        )
        @DisplayName("만약 각 문자가 중복된 값이나 길이가 3이 아닌 playerAnswer가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_input_exception_test(String playerInput) {
            assertThatThrownBy(() -> new GameNumbers(playerInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_INPUT);
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "012",
                    "a12",
                    "1 3"
                }
        )
        @DisplayName("만약 아스키 코드 상 1 ~ 9까지의 숫자가 아닌 playerAnswer가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_number_exception_test(String playerInput) {
            assertThatThrownBy(() -> new GameNumbers(playerInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_NUMBER);
        }
    }

    @Nested
    @DisplayName("calculateStrike 메소드는")
    class CalculateStrikeMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "123:156:1",
                    "123:126:2",
                    "123:123:3"
                },
                delimiter = ':'
        )
        @DisplayName("만약 GameNumber를 전달하면 스트라이크를 게산해서 반환한다.")
        void success_test(String computerInput, String playerInput, long expectStrike) {
            GameNumbers computerAnswer = new GameNumbers(computerInput);
            GameNumbers playerAnswer = new GameNumbers(playerInput);

            long resultStrike = computerAnswer.calculateStrike(playerAnswer);

            assertThat(resultStrike).isSameAs(expectStrike);
        }
    }

    @Nested
    @DisplayName("calculateBall 메소드는")
    class CalculateBallMethodTest {

        @ParameterizedTest
        @CsvSource(
                value = {
                    "123:278:1",
                    "123:218:2",
                    "123:231:3"
                },
                delimiter = ':'
        )
        @DisplayName("만약 GameNumber를 전달하면 볼을 게산해서 반환한다")
        void success_test(String computerInput, String playerInput, long expectBall) {
            GameNumbers computerAnswer = new GameNumbers(computerInput);
            GameNumbers playerAnswer = new GameNumbers(playerInput);

            long resultBall = computerAnswer.calculateBall(playerAnswer);

            assertThat(resultBall).isSameAs(expectBall);
        }
    }
}