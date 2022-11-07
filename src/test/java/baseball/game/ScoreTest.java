package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    Digits computer;

    @BeforeEach
    void 랜덤_갑_설정() {
        computer = Digits.create();
        computer.append(Digit.ONE);
        computer.append(Digit.TWO);
        computer.append(Digit.THREE);
    }

    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산1() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.THREE);
        player.append(Digit.TWO);
        Score score = Score.calculate(player, computer);

        assertThat(score.isOneStrike()).isEqualTo(true);
        assertThat(score.isTwoBall()).isEqualTo(true);
    }

    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산2() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.TWO);
        player.append(Digit.FOUR);
        Score score = Score.calculate(player, computer);

        assertThat(score.isTwoStrike()).isEqualTo(true);
        assertThat(score.isZeroBall()).isEqualTo(true);
    }

    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산3() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.TWO);
        player.append(Digit.THREE);
        Score score = Score.calculate(player, computer);

        assertThat(score.isThreeStrike()).isEqualTo(true);
        assertThat(score.isZeroBall()).isEqualTo(true);
    }

    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산4() {
        Digits player = Digits.create();
        player.append(Digit.TWO);
        player.append(Digit.THREE);
        player.append(Digit.ONE);
        Score score = Score.calculate(player, computer);

        assertThat(score.isZeroStrike()).isEqualTo(true);
        assertThat(score.isThreeBall()).isEqualTo(true);
    }

    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산5() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.FOUR);
        player.append(Digit.TWO);
        Score score = Score.calculate(player, computer);

        assertThat(score.isOneStrike()).isEqualTo(true);
        assertThat(score.isOneBall()).isEqualTo(true);
    }
}
