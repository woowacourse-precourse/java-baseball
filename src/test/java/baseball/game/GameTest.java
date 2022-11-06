package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class GameTest {
    @Nested
    @DisplayName("게임 시작 시")
    class WhenGameStarts {
        Game game;

        @BeforeEach
        public void before() {
            game = new Game();
        }

        @Test
        @DisplayName("3자리수가 생성된다.")
        public void generateThreeDigitNumber() {
            // when
            game.start();

            int first = game.randomNumber.first;
            int second = game.randomNumber.second;
            int third = game.randomNumber.third;

            // then
            assertThat(first).isNotNull();
            assertThat(second).isNotNull();
            assertThat(third).isNotNull();
        }


        @Test
        @DisplayName("각 자릿수가 다른 3자리수가 생성된다.")
        public void generateUniqueDigits() {
            // when
            game.start();

            int first = game.randomNumber.first;
            int second = game.randomNumber.second;
            int third = game.randomNumber.third;

            // then
            assertThat(first).isNotEqualTo(second);
            assertThat(second).isNotEqualTo(third);
            assertThat(third).isNotEqualTo(first);
        }
    }
}
