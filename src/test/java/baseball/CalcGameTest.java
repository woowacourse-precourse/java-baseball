package baseball;

import baseball.game.CalcGame;
import baseball.game.StrikeNumberGenerator;
import baseball.object.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcGameTest {

    @BeforeEach
    protected final void init() {
        CalcGame.setStrikeNumber(StrikeNumberGenerator.getStrikeNumber());
    }

    @Test
    void calcGameResult_3자리_초과_예외_발생() {
        assertThatThrownBy(() -> CalcGame.calcGameResult(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number length out of range");
    }

    @Test
    void calcGameResult_3자리_미만_예외_발생() {
        assertThatThrownBy(() -> CalcGame.calcGameResult(12))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number length out of range");
    }

    @Test
    void calcGameResult_인자가_1부터_9이외라면_예외_발생() {
        assertThatThrownBy(() -> CalcGame.calcGameResult(120))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Number length is 1 to 9");
    }

    @Test
    void calcGameResult_같은_숫자가_있으면_예외_발생() {
        assertThatThrownBy(() -> CalcGame.calcGameResult(111))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Numbers must consist of different letters");
    }

    @Test
    void calcGameResult_입력한_숫자에_따른_게임_결과_반환() {
        CalcGame.setStrikeNumber(123);

        GameResult gameResult = CalcGame.calcGameResult(135);
        assertThat(gameResult).isEqualTo(new GameResult(1, 1));
    }
}
