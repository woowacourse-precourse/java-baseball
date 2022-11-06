package baseball.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class GameTest {
    @Nested
    @DisplayName("게임 시작 시")
    class WhenInitialize{
        Game game;

        @BeforeEach
        public void before() {
            game = new Game();
            game.start();
        }

        @Test
        @DisplayName("3자리수가 생성된다.")
        public void generateThreeDigitNumber() {
            assertThat(game.digits.size()).isEqualTo(3);
        }


        @Test
        @DisplayName("각 자릿수가 다른 3자리수가 생성된다.")
        public void generateUniqueDigits() {
            Integer first = game.digits.get(0);
            Integer second = game.digits.get(1);
            Integer third = game.digits.get(2);

            assertThat(first).isNotEqualTo(second);
            assertThat(second).isNotEqualTo(third);
            assertThat(third).isNotEqualTo(first);
        }
    }
}
