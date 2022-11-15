package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.number.GameNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameJudgeTest {
    private GameJudge gameJudge;

    @BeforeEach
    public void setUp() {
        gameJudge = new GameJudge();
    }

    @Nested
    @DisplayName("개수를 제대로 세는가")
    class CountExactly {
        @Test
        public void 컴_425_플레이어_123() {
            GameNumber mockRandomNumber = GameNumber.of(425);
            GameNumber mockPlayerInput = GameNumber.of(123);

            GameResult result = gameJudge.countAndMakeResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(new GameResult(0, 1));
        }

        @Test
        public void 컴_425_플레이어_456() {
            GameNumber mockRandomNumber = GameNumber.of(425);
            GameNumber mockPlayerInput = GameNumber.of(456);

            GameResult result = gameJudge.countAndMakeResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(new GameResult(1, 1));
        }

        @Test
        public void 컴_425_플레이어_789() {
            GameNumber mockRandomNumber = GameNumber.of(425);
            GameNumber mockPlayerInput = GameNumber.of(789);

            GameResult result = gameJudge.countAndMakeResult(mockRandomNumber, mockPlayerInput);

            assertThat(result).isEqualTo(new GameResult(0, 0));
        }
    }

    @Nested
    @DisplayName("isThreeStrike 메서드는")
    class IsThreeStrike {
        @Test
        public void 모두_스트라이크_일때_true를_반환한다() {
            GameNumber mockRandomNumber = GameNumber.of(789);
            GameNumber mockPlayerInput = GameNumber.of(789);

            boolean isThreeStrike = gameJudge.isThreeStrike(mockRandomNumber, mockPlayerInput);

            assertThat(isThreeStrike).isTrue();
        }

        @Test
        public void 모두_스트라이크가_아니면_false를_반환한다() {
            GameNumber mockRandomNumber = GameNumber.of(789);
            GameNumber mockPlayerInput = GameNumber.of(127);

            boolean isThreeStrike = gameJudge.isThreeStrike(mockRandomNumber, mockPlayerInput);

            assertThat(isThreeStrike).isFalse();
        }
    }
}