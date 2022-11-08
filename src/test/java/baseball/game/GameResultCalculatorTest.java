package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.number.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameResultCalculatorTest {
    private GameResultCalculator gameResultCalculator;

    @BeforeEach
    public void setUp() {
        gameResultCalculator = new GameResultCalculator();
    }

    @Nested
    @DisplayName("개수를 제대로 세는가")
    class CountExactly {
        @Test
        public void 컴_425_플레이어_123() {
            Number mockRandomNumber = new Number(425);
            Number mockPlayerInput = new Number(123);

            List<Integer> result = gameResultCalculator.getResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(List.of(0, 1));
        }

        @Test
        public void 컴_425_플레이어_456() {
            Number mockRandomNumber = new Number(425);
            Number mockPlayerInput = new Number(456);

            List<Integer> result = gameResultCalculator.getResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(List.of(1, 1));
        }

        @Test
        public void 컴_425_플레이어_789() {
            Number mockRandomNumber = new Number(425);
            Number mockPlayerInput = new Number(789);

            List<Integer> result = gameResultCalculator.getResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(List.of(0, 0));
        }
    }
}