package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.number.Digit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BaseballGameTest {
    @Nested
    @DisplayName("게임 시작 시")
    class WhenGameStarts {
        BaseballGame game = new BaseballGame();
        Digit first;
        Digit second;
        Digit third;

        @BeforeEach
        public void before() {
            game.initialize();

            first = game.answer.first;
            second = game.answer.second;
            third = game.answer.third;
        }

        @Test
        @DisplayName("3자리수가 생성된다.")
        public void generateThreeDigitNumber() {
            assertThat(first).isNotNull();
            assertThat(second).isNotNull();
            assertThat(third).isNotNull();
        }


        @Test
        @DisplayName("각 자릿수가 다른 3자리수가 생성된다.")
        public void generateUniqueDigits() {
            assertThat(first).isNotEqualTo(second);
            assertThat(second).isNotEqualTo(third);
            assertThat(third).isNotEqualTo(first);
        }
    }
}
