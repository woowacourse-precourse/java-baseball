package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.number.GameNumbers;
import baseball.helper.factory.GameComputerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameComputerTest {

    @Nested
    @DisplayName("calculateGameResult 메소드는")
    class CalculateGameResultMethodTest {

        private static final String TOO_MANY_ANSWER = "잘못된 정답 개수입니다.";

        @ParameterizedTest
        @CsvSource(
                value = {
                    "123:456:0:0",
                    "123:145:1:0",
                    "123:132:1:2",
                    "123:451:0:1",
                    "123:123:3:0",
                    "123:312:0:3"
                },
                delimiter = ':'
        )
        @DisplayName("만약 PlayerAnswer가 주어지면 게임 결과를 GameResult 객체로 만들어 반환한다.")
        void success_test(String computerAnswer, String playerAnswer, long strike, long ball) {
            GameComputer gameComputer = GameComputerFactory.createGameComputer(computerAnswer);
            GameResult gameResult = gameComputer.calculateGameResult(new GameNumbers(playerAnswer));

            assertThat(gameResult.getStrike()).isEqualTo(strike);
            assertThat(gameResult.getBall()).isEqualTo(ball);
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
        @DisplayName("만약 strike, ball의 합이 4 이상인 PlayerAnswer가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void too_many_answer_exception_test(long strike, long ball) {
            GameComputer gameComputer = GameComputerFactory.createStubGameComputer(strike, ball);

            assertThatThrownBy(() -> gameComputer.calculateGameResult(new GameNumbers("123")))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(TOO_MANY_ANSWER);
        }
    }
}