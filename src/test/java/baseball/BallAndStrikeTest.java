package baseball;

import static baseball.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BallAndStrikeTest {
    @Test
    void of_메서드로_볼과_스트라이크_개수를_계산() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 2);

        BallAndStrike ballAndStrike = BallAndStrike.of(computer, player);
        int ball = ballAndStrike.getBall();
        int strike = ballAndStrike.getStrike();

        assertThat(ball).isEqualTo(2);
        assertThat(strike).isEqualTo(1);
    }

    @DisplayName("toString_메서드로_볼과_스트라이크_개수_출력")
    @Nested
    class toStringTest {
        @Test
        void 하나도_일치하지_않으면_낫싱_출력() {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> player = List.of(4, 5, 6);

            BallAndStrike ballAndStrike = BallAndStrike.of(computer, player);

            assertThat(ballAndStrike).hasToString(NOTHING);
        }

        @Test
        void 볼과_스트라이크가_모두_있는_경우_둘_다_출력() {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> player = List.of(1, 3, 2);

            BallAndStrike ballAndStrike = BallAndStrike.of(computer, player);

            assertThat(ballAndStrike).hasToString(2 + BALL + SPACE + 1 + STRIKE);
        }

        @Test
        void 스트라이크가_없는_경우_볼만_출력() {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> player = List.of(2, 1, 4);

            BallAndStrike ballAndStrike = BallAndStrike.of(computer, player);

            assertThat(ballAndStrike).hasToString(2 + BALL);
        }

        @Test
        void 볼이_없는_경우_스트라이크만_출력() {
            List<Integer> computer = List.of(1, 2, 3);
            List<Integer> player = List.of(1, 2, 4);

            BallAndStrike ballAndStrike = BallAndStrike.of(computer, player);

            assertThat(ballAndStrike).hasToString(2 + STRIKE);
        }
    }
}
