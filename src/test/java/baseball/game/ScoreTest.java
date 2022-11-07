package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @DisplayName("점수 계산이 이루어진다")
    @Test
    void 점수_계산() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.TWO);
        player.append(Digit.THREE);
        Digits computer = Digits.create();
        computer.append(Digit.ONE);
        computer.append(Digit.THREE);
        computer.append(Digit.TWO);
        Score score = Score.calculate(player, computer);

        assertThat(score.isOneStrike()).isEqualTo(true);
        assertThat(score.isTwoBall()).isEqualTo(true);
    }
}
