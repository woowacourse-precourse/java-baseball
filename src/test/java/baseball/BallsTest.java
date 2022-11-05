package baseball;

import baseball.ball.Balls;
import baseball.game.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Nested
    @DisplayName("Balls 생성자 테스트")
    class testConstruction {
        @Test
        @DisplayName("숫자가 3개 들어간 Balls 생성")
        void test3Balls() {
            new Balls(List.of(1, 2, 3));
        }

        @Test
        @DisplayName("숫자가 1개 들어간 Balls 생성 실패")
        void test1Balls() {
            assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Balls(List.of(1)));
        }
    }

    @Nested
    @DisplayName("사용자와 컴퓨터 게임하기")
    class testCompare {
        @Test
        @DisplayName("스트라이크 비교")
        void testCompareStrike() {
            Balls computer = new Balls(List.of(1, 2, 3));
            Balls player = new Balls(List.of(1, 2, 3));

            GameResult gameResult = computer.compare(player);
            assertThat(gameResult.getBall()).isEqualTo(0);
            assertThat(gameResult.getStrike()).isEqualTo(3);
        }

        @Test
        @DisplayName("볼과 스트라이크 비교")
        void testCompareStrikeAndBall() {
            Balls computer = new Balls(List.of(1, 2, 3));
            Balls player = new Balls(List.of(1, 3, 8));

            GameResult gameResult = computer.compare(player);
            assertThat(gameResult.getBall()).isEqualTo(1);
            assertThat(gameResult.getStrike()).isEqualTo(1);
        }

        @Test
        @DisplayName("낫싱 비교")
        void testCompareNoThing() {
            Balls computer = new Balls(List.of(1, 2, 3));
            Balls player = new Balls(List.of(4, 5, 6));

            GameResult gameResult = computer.compare(player);
            assertThat(gameResult.getBall()).isEqualTo(0);
            assertThat(gameResult.getStrike()).isEqualTo(0);
        }
    }
}
