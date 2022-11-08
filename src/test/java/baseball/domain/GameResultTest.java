package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    @DisplayName("판정 결과값 범위가 0 ~ 3이 아니고 카운트의 총 합이 3 초과할 시 객체 생성 실패")
    @ParameterizedTest
    @CsvSource({"-1, 1", "1, 4", "2, 2"})
    void out_bound(int strikeCounts, int ballCounts) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new GameResult(ballCounts, strikeCounts)
        );
    }

    @DisplayName("볼, 스트라이크 모두 못 맞춘 경우, isNoting -> True")
    @Test
    void is_nothing() {
        GameResult gameResult = new GameResult(0, 0);

        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("볼, 스트라이크 하나라도 맞춘 경우, isNothing -> False")
    @Test
    void is_nothing_false() {
        GameResult gameResult = new GameResult(1, 0);

        assertThat(gameResult.isNothing()).isFalse();
    }

    @DisplayName("볼이 0개, 스트라이크가 1개 이상인 경우, isOnlyStrike -> True")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void is_only_strike(int strikes) {
        GameResult gameResult = new GameResult(0, strikes);

        assertThat(gameResult.isOnlyStrike()).isTrue();
    }

    @DisplayName("볼이 1개 이상인 경우, isOnlyStrike -> False")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "1, 0"})
    void is_only_strike_false(int ballCounts, int strikeCounts) {
        GameResult gameResult = new GameResult(ballCounts, strikeCounts);

        assertThat(gameResult.isOnlyStrike()).isFalse();
    }

    @DisplayName("볼이 1개 이상, 스트라이크가 0개인 경우, isOnlyBall -> True")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void is_only_ball(int balls) {
        GameResult gameResult = new GameResult(balls, 0);

        assertThat(gameResult.isOnlyBall()).isTrue();
    }

    @DisplayName("스트라이크가 1개 이상인 경우, isOnlyBall -> False")
    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "0, 1"})
    void is_only_ball_fail(int ballCounts, int strikeCounts) {
        GameResult gameResult = new GameResult(ballCounts, strikeCounts);

        assertThat(gameResult.isOnlyBall()).isFalse();
    }

    @DisplayName("3스트라이크인 경우, ")
    @Test
    void three_strikes() {
        GameResult gameResult = new GameResult(0, 3);
        assertThat(gameResult.isGameEnds()).isTrue();
    }
}
