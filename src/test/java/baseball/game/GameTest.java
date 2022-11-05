package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class GameTest {
    @Nested
    @DisplayName("객체 생성 시")
    class WhenInitialize {

        @Test
        @DisplayName("3자리수가 생성된다.")
        public void generateThreeDigitNumber() {
            Game game = new Game();

            assertThat(game.digits.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("각 자릿수가 다른 3자리수가 생성된다.")
        public void generateUniqueDigits() {
            Game game = new Game();

            Integer first = game.digits.get(0);
            Integer second = game.digits.get(1);
            Integer third = game.digits.get(2);

            assertThat(first).isNotEqualTo(second);
            assertThat(second).isNotEqualTo(third);
            assertThat(third).isNotEqualTo(first);
        }
    }

}
