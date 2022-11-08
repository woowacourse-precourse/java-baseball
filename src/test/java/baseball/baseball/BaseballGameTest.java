package baseball.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @Nested
    class match {

        @Test
        @DisplayName("완벽인 경우")
        void caseComplete() {
            BaseballGame baseballGame = new BaseballGame();
            Digits digits1 = new Digits(List.of(1, 2, 3));
            Digits digits2 = new Digits(List.of(1, 2, 3));

            Result result = baseballGame.match(digits1, digits2);

            assertThat(result.isComplete()).isEqualTo(true);
        }

        @Test
        @DisplayName("낫싱인 경우")
        void caseNothing() {
            BaseballGame baseballGame = new BaseballGame();
            Digits digits1 = new Digits(List.of(4, 5, 6));
            Digits digits2 = new Digits(List.of(1, 2, 3));

            Result result = baseballGame.match(digits1, digits2);

            assertThat(result.isNothing()).isEqualTo(true);
        }

        @Test
        @DisplayName("2볼 1스트라이크인 경우")
        void caseTwoBallOneStrike() {
            BaseballGame baseballGame = new BaseballGame();
            Digits digits1 = new Digits(List.of(2, 1, 3));
            Digits digits2 = new Digits(List.of(1, 2, 3));

            Result result = baseballGame.match(digits1, digits2);

            assertThat(result.getBallCount()).isEqualTo(2);
            assertThat(result.getStrikeCount()).isEqualTo(1);
        }
    }
}