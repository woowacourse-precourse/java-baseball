package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameMachineTest {

    private Baseballs userBaseballs;

    @BeforeEach
    void setup() {
        userBaseballs = Baseballs.generateInputBaseballNumbers(Arrays.asList(1, 2, 3));
    }

    @DisplayName("3스트라이크")
    @Test
    void judge_three_strike() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(userBaseballs);

        GameResult gameResult = baseballGameMachine.judgeGameResult(userBaseballs);

        assertAll(
                () -> assertThat(gameResult.isGameEnds()).isTrue(),
                () -> assertThat(gameResult.isOnlyStrike()).isTrue()
        );
    }

    @DisplayName("낫싱")
    @Test
    void judge_nothing() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                Baseballs.generateInputBaseballNumbers(Arrays.asList(4, 5, 6)));

        GameResult gameResult = baseballGameMachine.judgeGameResult(userBaseballs);

        assertThat(gameResult.isNothing()).isTrue();
    }

    @DisplayName("3볼")
    @Test
    void judge_three_ball() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                Baseballs.generateInputBaseballNumbers(Arrays.asList(2, 3, 1)));

        GameResult gameResult = baseballGameMachine.judgeGameResult(userBaseballs);

        assertAll(
                () -> assertThat(gameResult.isOnlyBall()).isTrue(),
                () -> assertThat(gameResult.getBallCounts()).isEqualTo(3)
        );
    }

    @DisplayName("1스트라이크, 2볼")
    @Test
    void judge_t_one_strike_two_ball() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                Baseballs.generateInputBaseballNumbers(Arrays.asList(1, 3, 2)));

        GameResult gameResult = baseballGameMachine.judgeGameResult(userBaseballs);

        assertAll(
                () -> assertThat(gameResult.getStrikeCounts()).isEqualTo(1),
                () -> assertThat(gameResult.getBallCounts()).isEqualTo(2)
        );
    }

    @DisplayName("게임 KEEP_GOING시 동일한 머신 객체 반환")
    @Test
    void next_run_keep_going() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                Baseballs.generateRandomBaseballNumbers());

        BaseballGameMachine nextMachine = baseballGameMachine.play(GameState.KEEP_PLAY);

        assertThat(baseballGameMachine.equals(nextMachine)).isTrue();
    }

    @DisplayName("게임 RESTART시 새로운 객체 생성")
    @Test
    void next_run_restart() {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                Baseballs.generateRandomBaseballNumbers());

        BaseballGameMachine nextMachine = baseballGameMachine.play(GameState.RESTART);

        assertThat(baseballGameMachine.equals(nextMachine)).isFalse();
    }
}
