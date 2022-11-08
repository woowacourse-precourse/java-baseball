package baseball.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculatorTest {
    private static final Digits computer = Digits.create();

    @BeforeAll
    static void test() {
        computer.append(Digit.ONE);
        computer.append(Digit.TWO);
        computer.append(Digit.THREE);
    }

    @DisplayName("점수가 잘 계산됨")
    @Test
    void 잘_계산됨() {
        Digits player = Digits.create();
        player.append(Digit.ONE);
        player.append(Digit.THREE);
        player.append(Digit.TWO);
        ScoreCalculator scoreCalculator = ScoreCalculator.create(player, computer);
        assertThat(scoreCalculator.getBall()).isEqualTo(Ball.TWO);
        assertThat(scoreCalculator.getStrike()).isEqualTo(Strike.ONE);

    }
}
