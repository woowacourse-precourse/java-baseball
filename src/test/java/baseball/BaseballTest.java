package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    private final static int NUMBER_LIMIT = 3;
    private static BaseballGame sut;

    @BeforeAll
    static void initialization() {
        sut = new BaseballGame();
    }

    @Test
    void getStrike_각_자리에_맞는_스트라이크의_갯수_반환() {
        assertThat(sut.getStrike(123, 163)).isEqualTo(2);
        assertThat(sut.getStrike(123, 273)).isEqualTo(1);
    }

    @Test
    void getStrike_모든_숫자가_맞았을_경우_정답의_자리수와_같은_수_반환() {
        assertThat(sut.getStrike(123, 123)).isEqualTo(NUMBER_LIMIT);
    }

    @Test
    void getStrike_아무것도_맞지_않으면_0_반환() {
        assertThat(sut.getStrike(123, 456)).isEqualTo(0);
    }


}
